package com.nms.nms_user.service;

import com.nms.nms_user.Dto.UserResponseDto;
import com.nms.nms_user.entity.News;
import com.nms.nms_user.repository.NewsRepository;
import com.nms.nms_user.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SubscriptionRepository subscriptionRepository;
    private final NewsRepository newsRepository;

    //로그인한 사용자의 구독 뉴스 가져오기
    public UserResponseDto getUserContent(String username){
        try {
            List<News> subscriptions = subscriptionRepository.findByUsername(username);
            if (subscriptions == null) {
                subscriptions = Collections.emptyList();
            }
            return UserResponseDto.builder()
                    .username(username)
                    .subscribeNews(subscriptionRepository.findByUsername(username))
                    .Guest(false)
                    .build();
        }catch (Exception e){

            throw e;
        }
    }

    //게스트
    public UserResponseDto getGuestContent(){
        try {
            List<News> recentNews = newsRepository.findTop10ByOrderByPublishedAtDesc();
            if (recentNews == null) {
                recentNews = Collections.emptyList();
            }
            return UserResponseDto.builder()
                    .subscribeNews(newsRepository.findTop10ByOrderByPublishedAtDesc())
                    .Guest(true)
                    .build();
        }catch (Exception e){
            throw  e;
        }
    }



}
