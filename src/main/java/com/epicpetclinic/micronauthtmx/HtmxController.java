package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.views.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public abstract class HtmxController {

    private static final String DEFAULT_FRAGMENT = "content";

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
        final boolean isHtmxRequest = request.getHeaders().contains("HX-Request");
        model.put("isHtmxRequest", isHtmxRequest);
        final String finalView = isHtmxRequest ? view + " :: " + fragment : view;
        return HttpResponse.ok(new ModelAndView<>(finalView, model));
    }
}
