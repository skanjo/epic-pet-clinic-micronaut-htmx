package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.HashMap;
import java.util.Map;

@Controller("/owners")
public class OwnersController extends HtmxController {

    private final PageTitle pageTitle;

    public OwnersController(PageTitle pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Produces(MediaType.TEXT_HTML)
    @Get("/find")
    public HttpResponse<?> find(HttpRequest<?> request) {
        Map<String, Object> model = new HashMap<>();
        model.put("pageTitle", pageTitle.generate("Find Owners"));
        return render(request, "owners/find", model);
    }
}
