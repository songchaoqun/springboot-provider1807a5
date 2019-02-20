package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo-provider.xml"})
public class SpringbootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProviderApplication.class, args);
    }

}
