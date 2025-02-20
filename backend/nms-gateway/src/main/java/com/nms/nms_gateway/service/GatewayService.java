package com.nms.nms_gateway.service;

import com.nms.nms_gateway.config.GatewayConfig;
import com.nms.nms_mail.Dto.MailRequestDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GatewayService {

    private final RestTemplate restTemplate;
    private final GatewayConfig gatewayConfig;

    // RestTemplate을 주입받음
    public GatewayService(RestTemplate restTemplate, GatewayConfig gatewayConfig) {
        this.restTemplate = restTemplate;
        this.gatewayConfig = gatewayConfig;
    }

    // 인증 관련
    public String callAuthService(String path) {
        return restTemplate.getForObject(gatewayConfig.getBaseUrl() + path, String.class);
    }

    // 유저 서비스
    public String callUserService(String path) {
        return restTemplate.getForObject(gatewayConfig.getBaseUrl() + path, String.class);
    }

    // 뉴스 서비스
    public String callNewsService(String path) {
        return restTemplate.getForObject(gatewayConfig.getBaseUrl() + path, String.class);
    }

    // 메일 서비스 관련 스케줄링 (하루 2번 실행)
    @Scheduled(cron = "0 0 9,21 * * ?")
    public void sendScheduledEmails() {
        List<MailRequestDto> mailRequests = getSubscriptionUsers();

        for (MailRequestDto mailRequestDto : mailRequests) {
            sendEmail(mailRequestDto);
        }
    }

    // 실제 메일 전송 메서드
    public void sendEmail(MailRequestDto mailRequestDto) {
        restTemplate.postForObject(gatewayConfig.getBaseUrl() + "/mail/send", mailRequestDto, String.class);
    }

    // 사용자의 구독 정보 가져오기 (DB 연동 예정)
    public List<MailRequestDto> getSubscriptionUsers() {
        return List.of(
                new MailRequestDto("arto135@naver.com", "아침뉴스", "오늘의 뉴스 모음"),
                new MailRequestDto("arto135@naver.com", "저녁뉴스", "하루의 마지막을 장식하는 뉴스")
        );
    }
}
