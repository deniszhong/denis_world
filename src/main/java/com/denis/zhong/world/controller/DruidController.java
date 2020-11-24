package com.denis.zhong.world.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.denis.zhong.world.controller.vo.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DruidController {

    @RequestMapping("/druid/stat")
    public ResultDTO<Object> druidStat(){
        List<Map<String, Object>> data = DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        ResultDTO<Object> result = new ResultDTO<>();
        result.setData(data);
        return result;
    }
}
