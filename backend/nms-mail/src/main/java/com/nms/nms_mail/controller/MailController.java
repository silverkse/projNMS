package com.nms.nms_mail.controller;

import com.nms.nms_mail.Dto.MailRequestDto;
import com.nms.nms_mail.service.Mailservice;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final Mailservice mailservice;

    @Autowired
    public MailController(Mailservice mailservice){
        this.mailservice=mailservice;
    }

    @PostMapping("/mail/send")
    public String sendEmail(@RequestBody MailRequestDto mailRequestDto){
        try{
            mailservice.sendEmail(mailRequestDto);
            return "메일이 성공적으로 전송되었습니다.";
        }catch (MessagingException e){
            return "메일 전송 실패 :"+ e.getMessage();

        }
    }
}
