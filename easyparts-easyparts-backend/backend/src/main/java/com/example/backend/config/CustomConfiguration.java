package com.example.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// This configuration was added to fix a common error while making the requests.
// Issue: https://daveceddia.com/access-control-allow-origin-cors-errors-in-react-express/
// Solution: https://stackoverflow.com/questions/44697883/can-you-completely-disable-cors-support-in-spring
@Configuration
public class CustomConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }
}