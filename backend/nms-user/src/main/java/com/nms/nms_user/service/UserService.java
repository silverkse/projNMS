package com.nms.nms_user.service;

import com.nms.nms_user.Dto.UserResponseDto;
import com.nms.nms_user.repository.NewsRepository;
import com.nms.nms_user.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SubscriptionRepository subscriptionRepository;
    private final NewsRepository newsRepository;

    //로그인한 사용자의 구독 뉴스 가져오기
    public UserResponseDto getUserContent(String username){
        return UserResponseDto.builder()
                .username(username)
                .subscribeNews(subscriptionRepository.findByUsername(username))
                .Guest(false)
                .build();
    }

    //게스트 사용자용 뉴스 가져오기(크롤링된 뉴스)
    public UserResponseDto getUserContent(){
        return UserResponseDto.builder()
                .subscribeNews(newsRepository.findTop10ByOrderByPublishedAtDesc())
                .Guest(true)
                .build();
    }



}
