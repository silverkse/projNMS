package com.nms.nms_user.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    private String username;
    private List<String> subscribeNews;
    private boolean Guest;
}
