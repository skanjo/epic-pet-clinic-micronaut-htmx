package com.epicpetclinic.micronauthtmx;

import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.thymeleaf.TemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ThymeleafDialectConfigurer implements BeanCreatedEventListener<TemplateEngine> {

    private static final Logger log = LoggerFactory.getLogger(ThymeleafDialectConfigurer.class);

    @Override
    public TemplateEngine onCreated(@NonNull BeanCreatedEvent<TemplateEngine> event) {
        TemplateEngine engine = event.getBean();
        engine.addDialect(new LayoutDialect());
        return engine;
    }
}
