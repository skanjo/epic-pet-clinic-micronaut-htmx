package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.views.ModelAndView;

import java.util.Collections;
import java.util.Map;

public abstract class HtmxController {

    private static final String DEFAULT_FRAGMENT = "content";

    protected HttpResponse<?> render(HttpRequest<?> request, String view) {
        return render(request, view, DEFAULT_FRAGMENT, Collections.emptyMap());
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view, String fragment) {
        return render(request, view, fragment, Collections.emptyMap());
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view, Map<String, Object> model) {
        return this.render(request, view, DEFAULT_FRAGMENT, model);
    }

    protected HttpResponse<?> render(HttpRequest<?> request, String view, String fragment, Map<String, Object> model) {
        String htmxRequest = request.getHeaders().get("HX-Request");
        if (htmxRequest != null) {
            return HttpResponse.ok(new ModelAndView<>(view + " :: " + fragment, model));
        } else {
            return HttpResponse.ok(new ModelAndView<>(view, model));

        }
    }
}
