package com.pyszniutkie.fronend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate createRestTemplate(){
         RestTemplate restTemplate = new RestTemplate();
         return restTemplate;
    }
}
