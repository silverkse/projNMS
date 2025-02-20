package com.nms.nms_user.controller;

import com.nms.nms_user.Dto.UserResponseDto;
import com.nms.nms_user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")//스프링 부트 내부에선 /user로만 해도 됌
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;

        @GetMapping("/join")
        public UserResponseDto getCurrentUser(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            log.info("API요청 도찰: /api/user/join");
            log.info("API요청 도찰: {}", authentication);


            if(authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymouseUser")){
                log.info("게스트 유저 -> 크롤링된 뉴스 제공");
                return userService.getGuestContent();
                //게스트일 경우 크롤링된 뉴스 제공

            }
            log.info(" 로그인 유저 -> 구독 뉴스 제공",authentication.getName());

            return userService.getUserContent(authentication.getName());

            //로그인된 사용자라면 구독 뉴스 제공
        }
}
