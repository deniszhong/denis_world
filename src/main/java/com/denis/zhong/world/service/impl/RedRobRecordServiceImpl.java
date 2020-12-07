package com.denis.zhong.world.service.impl;

import com.denis.zhong.world.entity.RedRobRecord;
import com.denis.zhong.world.dao.RedRobRecordDao;
import com.denis.zhong.world.service.RedRobRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 抢红包记录表(RedRobRecord)表服务实现类
 *
 * @author deniszhong
 * @since 2020-12-03 15:29:02
 */
@Service("redRobRecordService")
public class RedRobRecordServiceImpl implements RedRobRecordService {
    @Resource
    private RedRobRecordDao redRobRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RedRobRecord queryById(Long id) {
        return this.redRobRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RedRobRecord> queryAllByLimit(int offset, int limit) {
        return this.redRobRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param redRobRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RedRobRecord insert(RedRobRecord redRobRecord) {
        this.redRobRecordDao.insert(redRobRecord);
        return redRobRecord;
    }

    /**
     * 修改数据
     *
     * @param redRobRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RedRobRecord update(RedRobRecord redRobRecord) {
        this.redRobRecordDao.update(redRobRecord);
        return this.queryById(redRobRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.redRobRecordDao.deleteById(id) > 0;
    }
}