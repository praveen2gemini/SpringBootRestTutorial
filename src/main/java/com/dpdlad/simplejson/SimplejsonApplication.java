package com.dpdlad.simplejson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimplejsonApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SimplejsonApplication.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()
        ) {
            System.out.println("Bean name is " + name);
        }
    }

}
