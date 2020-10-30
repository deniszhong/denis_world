package com.denis.zhong.world.controller;

import com.denis.zhong.world.mapper.entity.Topic;
import com.denis.zhong.world.service.TopicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 主题(Topic)表控制层
 *
 * @author deniszhong
 * @since 2020-10-30 14:38:41
 */
@RestController
@RequestMapping("topic")
public class TopicController {
    /**
     * 服务对象
     */
    @Resource
    private TopicService topicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Topic selectOne(Integer id) {
        return this.topicService.queryById(id);
    }

}