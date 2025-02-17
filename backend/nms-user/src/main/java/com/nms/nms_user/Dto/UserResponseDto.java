package com.nms.nms_user.Dto;

import com.nms.nms_user.entity.News; //News 엔티티 임포트
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    private String username;
    private List<News> subscribeNews;
    private boolean Guest;
}
