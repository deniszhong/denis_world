package com.denis.zhong.world.dao;

import com.denis.zhong.world.entity.Topic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 主题(Topic)表数据库访问层
 *
 * @author deniszhong
 * @since 2020-10-31 14:50:38
 */
@Repository
public interface TopicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Topic queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Topic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Topic> queryAllForPageList();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param topic 实例对象
     * @return 对象列表
     */
    List<Topic> queryAll(Topic topic);

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 影响行数
     */
    int insert(Topic topic);

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 影响行数
     */
    int update(Topic topic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}