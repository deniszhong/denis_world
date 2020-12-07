package com.denis.zhong.world.controller;


import com.denis.zhong.world.controller.vo.ResultDTO;
import com.denis.zhong.world.entity.RedRecord;
import com.denis.zhong.world.service.RedRecordService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("red")
public class RedPackageController {

    @Resource
    private RedRecordService redRecordService;

    @RequestMapping("/{userId}/{money}/{num}")
    public ResultDTO<Boolean> giveGift(@PathVariable("userId") Integer userId,
                                       @PathVariable("money") Integer money,
                                       @PathVariable("num") Integer num){
        //不做参数校验
        RedRecord redRecord = new RedRecord();
        redRecord.setAmount(money);
        redRecord.setNum(num);
        redRecord.setDeleted(0);
        redRecord.setUserId(userId);
        redRecord.setCreateTime(new Date());
        redRecord.setModifyTime(new Date());

        redRecordService.insert(redRecord);
        return new ResultDTO<>(true);
    }
}
