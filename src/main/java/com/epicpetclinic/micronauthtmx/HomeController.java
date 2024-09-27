package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.View;

@Controller("/")
public class HomeController {

    @Produces(MediaType.TEXT_HTML)
    @View("index")
    @Get
    public void index() {
    }
}
