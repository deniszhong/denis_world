package com.denis.zhong.world.service;

import com.denis.zhong.world.entity.RedDetail;
import com.denis.zhong.world.service.bo.RobRedPackageBO;

import java.util.List;

/**
 * 红包明细表(RedDetail)表服务接口
 *
 * @author deniszhong
 * @since 2020-12-03 15:28:38
 */
public interface RedDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RedDetail queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RedDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param redDetail 实例对象
     * @return 实例对象
     */
    RedDetail insert(RedDetail redDetail);

    /**
     * 修改数据
     *
     * @param redDetail 实例对象
     * @return 实例对象
     */
    RedDetail update(RedDetail redDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 抢红包
     * @param robRedPackageBO
     * @return
     */
    RedDetail robRedPackage(RobRedPackageBO robRedPackageBO);

}