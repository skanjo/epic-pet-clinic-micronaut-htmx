package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.thymeleaf.ThymeleafViewsRenderer;

import java.util.HashMap;
import java.util.Map;

@Controller("/home")
public class HomeController extends HtmxController {

    private final PageTitle pageTitle;

    public HomeController(PageTitle pageTitle, ThymeleafViewsRenderer<Map<String, Object>> renderer) {
        super(renderer);
        this.pageTitle = pageTitle;
    }

    @Produces(MediaType.TEXT_HTML)
    @Get
    public HttpResponse<?> index(HttpRequest<?> request) {
        Map<String, Object> model = new HashMap<>();
        model.put("pageTitle", pageTitle.generate("Home"));
        return render(request, "home/index", model);
    }
}
