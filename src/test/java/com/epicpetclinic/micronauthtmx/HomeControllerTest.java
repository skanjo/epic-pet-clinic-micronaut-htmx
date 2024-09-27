package com.epicpetclinic.micronauthtmx;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class HomeControllerTest {

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
    public void testIndex() {
        String title = "Epic Pet Clinic";

        HttpRequest<?> request = HttpRequest.GET("/").accept(MediaType.TEXT_HTML);
        String html = client.toBlocking().retrieve(request);

        assertNotNull(html);
        assertTrue(html.contains("<!DOCTYPE html>"));
        assertTrue(html.contains("<title>" + title + "</title>"));
        assertTrue(html.contains("<h1 class=\"text-4xl\">" + title + "</h1>"));
    }

}
