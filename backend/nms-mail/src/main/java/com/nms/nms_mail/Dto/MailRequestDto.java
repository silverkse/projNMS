package com.nms.nms_mail.Dto;

import lombok.Data;

@Data

public class MailRequestDto {
    private String from;   //보내는 사람
    private String to;      //받는 사람
    private String subject; //제목
    private String text;    //내용
}
