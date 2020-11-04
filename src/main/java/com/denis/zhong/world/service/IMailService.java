package com.denis.zhong.world.service;

import com.denis.zhong.world.service.bo.SendMailBO;

public interface IMailService {

   Boolean sendSimpleEmail(SendMailBO mailBO);

   Boolean sendEmailWithAttachment(SendMailBO mailBO);
}
