package com.nms.nms_mail.service;

import com.nms.nms_mail.Dto.MailRequestDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Mailservice {

    private final JavaMailSender mailSender;

    @Autowired
    public Mailservice(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }

    public void sendEmail(MailRequestDto mailRequestDto)throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom(mailRequestDto.getFrom());  //보내는 사람
        messageHelper.setTo(mailRequestDto.getTo());      //받는 사람
        messageHelper.setSubject(mailRequestDto.getSubject());    //제목
        messageHelper.setText(mailRequestDto.getText());          //내용(요약 으로 바꿀것)

        mailSender.send(mimeMessage);
    }
}
