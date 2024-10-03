package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.HashMap;
import java.util.Map;

@Controller("/vets")
public class VeterinariansController extends HtmxController {

    private final PageTitle pageTitle;

    public VeterinariansController(PageTitle pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Produces(MediaType.TEXT_HTML)
    @Get("/find")
    public HttpResponse<?> find(HttpRequest<?> request) {
        Map<String, Object> model = new HashMap<>();
        model.put("pageTitle", pageTitle.generate("Veterinarians"));
        return render(request, "vets/index", model);
    }
}
