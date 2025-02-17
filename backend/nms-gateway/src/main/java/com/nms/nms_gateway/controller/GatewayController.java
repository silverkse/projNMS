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

    public GatewayController(GatewayService gatewayService){
        this.gatewayService= gatewayService;
    }
    //인증 요청 전달
    @GetMapping("/auth/**")
    public Mono<String> handleAuthRequest(@RequestParam String path){
        return gatewayService.callAuthService(path);
        //Aws api gateway로 요청을 전달
    }

    //사용자 관련 요청 전달
    @GetMapping("/user/**")
    public Mono<String> handleUserRequest(@RequestParam String path){
        return  gatewayService.callUserService(path);
    }

    //뉴스 관련 요청 전달
    @GetMapping("/news/**")
    public Mono<String> handleNewsRequest(@RequestParam String path){
        return gatewayService.callNewsService(path);
    }

    //메일 관련 요청 전달
    @PostMapping("/send")
    public Mono<String> sendMail(@RequestBody MailRequestDto mailRequestDto){
        return gatewayService.callMailService("/mail/send",mailRequestDto);
    }
}
