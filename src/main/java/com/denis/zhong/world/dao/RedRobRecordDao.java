package com.denis.zhong.world.dao;

import com.denis.zhong.world.entity.RedRobRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 抢红包记录表(RedRobRecord)表数据库访问层
 *
 * @author deniszhong
 * @since 2020-12-03 15:29:02
 */
public interface RedRobRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RedRobRecord queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RedRobRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param redRobRecord 实例对象
     * @return 对象列表
     */
    List<RedRobRecord> queryAll(RedRobRecord redRobRecord);

    /**
     * 新增数据
     *
     * @param redRobRecord 实例对象
     * @return 影响行数
     */
    int insert(RedRobRecord redRobRecord);

    /**
     * 修改数据
     *
     * @param redRobRecord 实例对象
     * @return 影响行数
     */
    int update(RedRobRecord redRobRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}