package com.nms.nms_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    //webClient를 사용해서 aws api gateway를 호출할수  있음
    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
