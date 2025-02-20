package com.nms.nms_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionConfig {
    @Bean
    public Function<String, String> processRequest(){
        return input -> "Hello from Lamda! Input :" + input;
    }
}
