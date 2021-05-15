package com.dpdlad.simplejson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleJsonApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SimpleJsonApplication.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()
        ) {
            System.out.println("Bean name is " + name);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SimpleJsonApplication.class);
    }
}
