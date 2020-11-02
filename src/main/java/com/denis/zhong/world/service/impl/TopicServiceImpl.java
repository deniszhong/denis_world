package com.denis.zhong.world.service.impl;

import com.denis.zhong.world.entity.Topic;
import com.denis.zhong.world.dao.TopicDao;
import com.denis.zhong.world.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主题(Topic)表服务实现类
 *
 * @author deniszhong
 * @since 2020-10-31 14:50:39
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Topic queryById(Integer id) {
        return this.topicDao.queryById(id);
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
        return this.topicDao.queryAllByLimit(offset, limit);
    }

    @Override
    public PageInfo<Topic> queryPageTopicInfo(int offset, int limit) {
        PageInfo<Topic> topicPageInfo = PageHelper.startPage(offset,limit).doSelectPageInfo(()->topicDao.queryAllForPageList());
        return topicPageInfo;
    }

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    @Override
    public Topic insert(Topic topic) {
        this.topicDao.insert(topic);
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
        this.topicDao.update(topic);
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
        return this.topicDao.deleteById(id) > 0;
    }
}