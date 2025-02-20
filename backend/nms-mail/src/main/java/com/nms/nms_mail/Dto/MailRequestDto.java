package com.nms.nms_mail.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor  // 기본 생성자와 파라미터 생성자를 둘 다 생성해줍니다.
public class MailRequestDto {
    private String email;
    private String subject;
    private String body;

}
