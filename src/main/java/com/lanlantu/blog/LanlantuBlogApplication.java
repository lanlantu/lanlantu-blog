package com.lanlantu.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class LanlantuBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanlantuBlogApplication.class, args);
    }

}
