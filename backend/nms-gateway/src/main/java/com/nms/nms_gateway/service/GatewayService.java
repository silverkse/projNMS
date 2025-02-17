package com.nms.nms_gateway.service;

import com.nms.nms_gateway.config.GatewayConfig;
import com.nms.nms_mail.Dto.MailRequestDto; // MailRequestDto 추가
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GatewayService {

    private final WebClient.Builder webClientBuilder;
    private final GatewayConfig gatewayConfig;

    // 생성자를 통해 의존성 주입
    public GatewayService(WebClient.Builder webClientBuilder, GatewayConfig gatewayConfig) {
        this.webClientBuilder = webClientBuilder;
        this.gatewayConfig = gatewayConfig;
    }

    // 인증 관련
    public Mono<String> callAuthService(String path) {
        return webClientBuilder.baseUrl(gatewayConfig.getBaseUrl())
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(path).build())
                .retrieve()
                .bodyToMono(String.class);
    }

    // 유저 서비스
    public Mono<String> callUserService(String path) {
        return webClientBuilder.baseUrl(gatewayConfig.getBaseUrl())
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(path).build())
                .retrieve()
                .bodyToMono(String.class);
    }

    // 뉴스 서비스
    public Mono<String> callNewsService(String path) {
        return webClientBuilder.baseUrl(gatewayConfig.getBaseUrl())
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(path).build())
                .retrieve()
                .bodyToMono(String.class);
    }

    // 메일 서비스
    public Mono<String> sendEmail(MailRequestDto mailRequestDto) {
        return webClientBuilder.baseUrl(gatewayConfig.getBaseUrl())  // API Gateway URL을 설정
                .build()
                .post()  // POST 방식으로 메일 전송
                .uri("/mail/send")  // 메일 전송을 위한 엔드포인트 경로
                .bodyValue(mailRequestDto)  // 메일 요청 DTO를 요청 본문에 추가
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> callMailService(String path, MailRequestDto mailRequestDto) {
        return webClientBuilder.baseUrl(gatewayConfig.getBaseUrl())
                .build()
                .post() //Post 방식으로 전송
                .uri(path) // 동적으로 전달받은? path사용
                .bodyValue(mailRequestDto) //메일 요청 DTO를 본문에 추가
                .retrieve()
                .bodyToMono(String.class);  //응답 본문을 String으로 받기
    }
}
