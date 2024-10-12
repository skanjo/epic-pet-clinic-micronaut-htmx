package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.ModelAndView;

import java.util.Collections;

@Controller("/error")
public class ErrorController {

    @Produces(MediaType.TEXT_HTML)
    @Get
    public HttpResponse<?> index(HttpRequest<?> request) {
        final String view = request.getHeaders().contains("HX-Request") ? "error/index" : "error";
        return HttpResponse.ok(new ModelAndView<>(view, Collections.emptyMap()));
    }
}
