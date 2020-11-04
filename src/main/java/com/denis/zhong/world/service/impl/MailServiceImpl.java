package com.denis.zhong.world.service.impl;

import com.denis.zhong.world.service.IMailService;
import com.denis.zhong.world.service.bo.SendMailBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements IMailService {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender mailSender;

    private final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Override
    public Boolean sendSimpleEmail(SendMailBO mailBO) {

            //创建SimpleMailMessage对象
            SimpleMailMessage message = new SimpleMailMessage();
            //邮件发送人
            message.setFrom(from);
            //邮件接收人
            message.setTo(mailBO.getTo());
            //邮件主题
            message.setSubject(mailBO.getSubject());
            //邮件内容
            message.setText(mailBO.getContent());
            //发送邮件
            mailSender.send(message);
            return true;

    }

    @Override
    public Boolean sendEmailWithAttachment(SendMailBO mailBO) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(mailBO.getTo());
            helper.setSubject(mailBO.getSubject());
            helper.setText(mailBO.getContent(),mailBO.getHtmlStyle());
            if(!StringUtils.isEmpty(mailBO.getFilePath())){
                FileSystemResource file = new FileSystemResource(new File(mailBO.getFilePath()));
                String fileName = mailBO.getFilePath().substring(mailBO.getFilePath().lastIndexOf(File.separator));
                helper.addAttachment(fileName, file);
            }
            mailSender.send(message);
        } catch (MessagingException e) {
           logger.error("Email send fail");
           //TODO persistence
           return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
