package com.denis.zhong.world.service.impl;

import com.denis.zhong.world.mapper.entity.Topic;
import com.denis.zhong.world.mapper.TopicMapper;
import com.denis.zhong.world.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主题(Topic)表服务实现类
 *
 * @author deniszhong
 * @since 2020-10-30 14:38:41
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicMapper topicMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Topic queryById(Integer id) {
        return this.topicMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Topic> queryAllByLimit(int offset, int limit) {
        return this.topicMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    @Override
    public Topic insert(Topic topic) {
        this.topicMapper.insert(topic);
        return topic;
    }

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    @Override
    public Topic update(Topic topic) {
        this.topicMapper.update(topic);
        return this.queryById(topic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.topicMapper.deleteById(id) > 0;
    }
}