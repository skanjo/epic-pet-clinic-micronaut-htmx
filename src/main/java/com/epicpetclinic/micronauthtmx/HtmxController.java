package com.epicpetclinic.micronauthtmx;

import io.micronaut.core.io.Writable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.thymeleaf.ThymeleafViewsRenderer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class HtmxController {

    private static final String DEFAULT_FRAGMENT = "content";
    private static final String DEFAULT_MAIN_TEMPLATE = "layouts/main";

    private final ThymeleafViewsRenderer<Map<String, Object>> renderer;

    protected HtmxController(ThymeleafViewsRenderer<Map<String, Object>> renderer) {
        this.renderer = renderer;
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view) {
        return render(request, view, DEFAULT_FRAGMENT, new HashMap<>());
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view, String fragment) {
        return render(request, view, fragment, new HashMap<>());
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view, Map<String, Object> model) {
        return this.render(request, view, DEFAULT_FRAGMENT, model);
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view, String fragment, Map<String, Object> model) {
        final String fragmentView = view + " :: " + fragment;

        final boolean isHxRequest = request.getHeaders().contains("HX-Request");
        if (isHxRequest) {
            return HttpResponse.ok(new ModelAndView<>(fragmentView, model));
        }

        Writable contentWritable = renderer.render(fragmentView, model, request);
        String fragmentContent = getStringFromWritable(contentWritable);
        model.put("content", fragmentContent);

        return HttpResponse.ok(new ModelAndView<>(DEFAULT_MAIN_TEMPLATE, model));
    }

    private String getStringFromWritable(Writable writable) {
        StringWriter stringWriter = new StringWriter();
        try {
            writable.writeTo(stringWriter);
        } catch (IOException e) {
            return "Error rendering content";
        }
        return stringWriter.toString();
    }
}
