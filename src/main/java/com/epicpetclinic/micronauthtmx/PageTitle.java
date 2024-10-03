package com.epicpetclinic.micronauthtmx;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

@Singleton
public class PageTitle {

    private final String appTitle;

    public PageTitle(ApplicationConfig config) {
        this.appTitle = config.getAppTitle();
    }

    public String generate() {
        return appTitle;
    }

    public String generate(@NonNull String contentTitle) {
        if (contentTitle != null && !contentTitle.isEmpty()) {
            return appTitle + " - " + contentTitle;
        }
        return appTitle;
    }
}
