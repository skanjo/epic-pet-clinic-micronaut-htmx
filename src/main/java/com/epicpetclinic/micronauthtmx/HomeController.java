package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.ModelAndView;

import java.net.URI;
import java.util.Collections;

@Controller
public class HomeController {

    @Get
    public HttpResponse<?> root() {
        return HttpResponse.temporaryRedirect(URI.create("/home"));
    }

    @Produces(MediaType.TEXT_HTML)
    @Get("/home")
    public HttpResponse<?> index(HttpRequest<?> request) {
        final String view = request.getHeaders().contains("HX-Request") ? "home/index-fragment" : "home/index-page";
        return HttpResponse.ok(new ModelAndView<>(view, Collections.emptyMap()));
    }
}
