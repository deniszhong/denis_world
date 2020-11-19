package com.denis.zhong.world.controller;

import com.denis.zhong.world.controller.vo.ResultDTO;
import com.denis.zhong.world.service.IMailService;
import com.denis.zhong.world.service.bo.SendMailBO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Resource
    private IMailService mailService;

    @RequestMapping("/send")
    public ResultDTO<Boolean> sendMail(){
        SendMailBO mailBO = new SendMailBO();
        mailBO.setContent("测试");
        mailBO.setSubject("测试");
        mailBO.setTo(new String[]{"549255020@qq.com","god_world@163.com","126.com"});

        Boolean flag = mailService.sendSimpleEmail(mailBO);
        ResultDTO result =  new ResultDTO<Boolean>();
        result.setData(flag);
        return result;
    }

    @GetMapping("/send/attach")
    public ResultDTO<Boolean> sendMailWithAttach(){
        SendMailBO mailBO = new SendMailBO();
        mailBO.setContent("<h1>html带附件测试</h1>");
        mailBO.setSubject("<h1>html带附件测试</h1>");
        mailBO.setTo(new String[]{"549255020@qq.com","god_world@163.com"});
        mailBO.setHtmlStyle(true);
        //ClassPathResource
        mailBO.setFilePath(System.getProperty("user.home")+File.separator+"export.sql");
        ResultDTO result = new ResultDTO<Boolean>();
        result.setData(mailService.sendEmailWithAttachment(mailBO));
        return result;
    }
}
