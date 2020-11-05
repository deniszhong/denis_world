package com.denis.zhong.world.controller;

import com.denis.zhong.world.controller.vo.ResultDTO;
import com.denis.zhong.world.entity.Topic;
import com.denis.zhong.world.service.TopicService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 主题(Topic)表控制层
 *
 * @author deniszhong
 * @since 2020-10-31 14:50:40
 */
@RestController
@RequestMapping("/topic")
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
    @RequestMapping("/selectOne/{id}")
    public ResultDTO<Topic> selectOne(@PathVariable("id") Integer id) {
        ResultDTO<Topic> result= new ResultDTO<>();
        Topic topic = this.topicService.queryById(id);
        result.setData(topic);
        return result;

    }

    @RequestMapping("/selectOne/{offset}/{limit}")
    public PageInfo<Topic> getTopicForPage(@PathVariable("offset") Integer offset,@PathVariable("limit") Integer limit){
        return topicService.queryPageTopicInfo(offset,limit);
    }

}