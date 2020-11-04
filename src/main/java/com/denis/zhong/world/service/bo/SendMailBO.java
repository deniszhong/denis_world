package com.denis.zhong.world.service.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailBO {

    //邮件内容
    private String content;

    //收件人
    private String[] to;

    //主题
    private String subject;

    //是否html格式
    private Boolean htmlStyle;

    //附件地址
    private String filePath;
}
