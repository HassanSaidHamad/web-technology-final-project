package com.system.online.inventory.management.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //        user profile image
        Path userUploadDir = Paths.get("./user-profiles");
        String userUploadPath = userUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/user-images/**")
                .addResourceLocations("file:/" + userUploadPath + "/");


        //        product image
        Path productUploadDir = Paths.get("./product-images");
        String productUploadPath = productUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/product-images/**")
                .addResourceLocations("file:/" + productUploadPath + "/");

    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login/login")
                .setViewName("login/login");

        registry.addViewController("/dashboard/my_users_dashboard")
                .setViewName("dashboard/my_users_dashboard");

    }
}
