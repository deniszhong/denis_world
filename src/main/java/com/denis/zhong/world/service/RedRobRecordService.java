package com.denis.zhong.world.service;

import com.denis.zhong.world.entity.RedRobRecord;
import java.util.List;

/**
 * 抢红包记录表(RedRobRecord)表服务接口
 *
 * @author deniszhong
 * @since 2020-12-03 15:29:02
 */
public interface RedRobRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RedRobRecord queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RedRobRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param redRobRecord 实例对象
     * @return 实例对象
     */
    RedRobRecord insert(RedRobRecord redRobRecord);

    /**
     * 修改数据
     *
     * @param redRobRecord 实例对象
     * @return 实例对象
     */
    RedRobRecord update(RedRobRecord redRobRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}