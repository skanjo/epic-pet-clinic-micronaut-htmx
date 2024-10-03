package com.epicpetclinic.micronauthtmx;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;

@ConfigurationProperties("application")
public interface ApplicationConfig {

    @NonNull
    String getAppTitle();

}
