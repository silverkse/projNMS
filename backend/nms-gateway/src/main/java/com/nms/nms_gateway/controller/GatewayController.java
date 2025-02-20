package com.nms.nms_gateway.controller;

import com.nms.nms_gateway.service.GatewayService;
import com.nms.nms_mail.Dto.MailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class GatewayController {

    private final GatewayService gatewayService;

    // 인증 요청 전달
    @GetMapping("/auth/**")
    public String handleAuthRequest(@RequestParam String path) {
        return gatewayService.callAuthService(path); // Mono 제거
    }

    // 사용자 관련 요청 전달
    @GetMapping("/user/**")
    public String handleUserRequest(@RequestParam String path) {
        return gatewayService.callUserService(path); // Mono 제거
    }

    // 뉴스 관련 요청 전달
    @GetMapping("/news/**")
    public String handleNewsRequest(@RequestParam String path) {
        return gatewayService.callNewsService(path); // Mono 제거
    }

    // 메일 관련 요청 전달
    @PostMapping("/send")
    public void sendMail(@RequestBody MailRequestDto mailRequestDto) {
        gatewayService.sendEmail(mailRequestDto); // Mono 제거
    }
}
