package com.nms.nms_gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "api.gateway")
//ConfigurationProperties 프로퍼티스에 있는 api.gateway를 스프링에서 자도으로 GatewayConfig에 바인딩해줌
public class GatewayConfig {
    private String baseUrl;
}
