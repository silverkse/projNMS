package com.nms.nms_user.controller;

import com.nms.nms_user.Dto.UserResponseDto;
import com.nms.nms_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;

        @GetMapping("/join")
        public UserResponseDto getCurrentUser(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymouseUser")){
                return userService.getGuestContent();
                //게스트일 경우 크롤링된 뉴스 제공
            }

            return userService.getUserContent(authentication.getName());
            //로그인된 사용자라면 구독 뉴스 제공
        }
}
