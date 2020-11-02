package com.denis.zhong.world.service;

import com.denis.zhong.world.entity.Topic;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 主题(Topic)表服务接口
 *
 * @author deniszhong
 * @since 2020-10-31 14:50:39
 */
@Mapper
public interface TopicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Topic queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Topic> queryAllByLimit(int offset, int limit);

    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    PageInfo<Topic> queryPageTopicInfo(int offset,int limit);

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    Topic insert(Topic topic);

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    Topic update(Topic topic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}