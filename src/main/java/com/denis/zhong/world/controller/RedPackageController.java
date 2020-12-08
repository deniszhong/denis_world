package com.denis.zhong.world.controller;


import com.denis.zhong.world.controller.vo.ResultDTO;
import com.denis.zhong.world.entity.RedDetail;
import com.denis.zhong.world.entity.RedRecord;
import com.denis.zhong.world.service.RedDetailService;
import com.denis.zhong.world.service.RedRecordService;
import com.denis.zhong.world.service.bo.RobRedPackageBO;
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

    @Resource
    private RedDetailService redDetailService;

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

    @RequestMapping("/rob/{redRecordId}/{userId}")
    public ResultDTO<RedDetail> robRedPackage(@PathVariable("redRecordId") Long redRecordId,
                                              @PathVariable("userId") Long userId){
        RobRedPackageBO bo = new RobRedPackageBO();
        bo.setRedRecordId(redRecordId);
        bo.setUserId(userId);
        RedDetail redDetail = redDetailService.robRedPackage(bo);
        ResultDTO<RedDetail> resultDTO = new ResultDTO<>(redDetail);
        return resultDTO;
    }
}
