package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.ModelAndView;

import java.util.Collections;

@Controller("/vets")
public class VeterinariansController {

    @Produces(MediaType.TEXT_HTML)
    @Get("/find")
    public HttpResponse<?> find(HttpRequest<?> request) {
        final String view = request.getHeaders().contains("HX-Request") ? "vets/index" : "find-vets";
        return HttpResponse.ok(new ModelAndView<>(view, Collections.emptyMap()));
    }
}
