package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/home")
public class HomeController extends HtmxController {

    @Produces(MediaType.TEXT_HTML)
    @Get
    public HttpResponse<?> index(HttpRequest<?> request) {
        return render(request, "home/index");
    }
}
