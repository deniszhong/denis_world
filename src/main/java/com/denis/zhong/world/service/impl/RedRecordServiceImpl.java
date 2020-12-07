package com.denis.zhong.world.service.impl;

import com.denis.zhong.world.dao.RedDetailDao;
import com.denis.zhong.world.entity.RedDetail;
import com.denis.zhong.world.entity.RedRecord;
import com.denis.zhong.world.dao.RedRecordDao;
import com.denis.zhong.world.service.RedRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 红包记录表(RedRecord)表服务实现类
 *
 * @author deniszhong
 * @since 2020-12-03 15:10:27
 */
@Service("redRecordService")
public class RedRecordServiceImpl implements RedRecordService {

    @Resource
    private RedRecordDao redRecordDao;

    @Resource
    private RedDetailDao redDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RedRecord queryById(Long id) {
        return this.redRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<RedRecord> queryAllByLimit(int offset, int limit) {
        return this.redRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param redRecord 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public RedRecord insert(RedRecord redRecord) {
        this.redRecordDao.insert(redRecord);
        List<RedDetail> redDetailList = this.randomRedForUser(redRecord.getAmount(),redRecord.getNum(),redRecord.getId());
        redDetailDao.batchInsert(redDetailList);
        return redRecord;
    }

    /**
     * 修改数据
     *
     * @param redRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RedRecord update(RedRecord redRecord) {
        this.redRecordDao.update(redRecord);
        return this.queryById(redRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.redRecordDao.deleteById(id) > 0;
    }

    /**
     * 随机生成红包
     * @param amount
     * @param number
     * @param redRecordId
     * @return
     */
    private List<RedDetail> randomRedForUser(int amount, int number, Long redRecordId) {
        List<RedDetail> redDetailList = new ArrayList<>();
        while (number > 1) {
            int maxRandom = amount / number * 2;
            int perAmount = ThreadLocalRandom.current().nextInt(maxRandom);
            RedDetail detail = buildDetail(perAmount, redRecordId);
            number--;
            amount = amount - perAmount;
            redDetailList.add(detail);
        }
        RedDetail detail = buildDetail(amount, redRecordId);
        redDetailList.add(detail);
        return redDetailList;
    }

    private RedDetail buildDetail(Integer amount, Long redRecordId) {
        RedDetail detail = new RedDetail();
        detail.setRedPerAmount(amount);
        detail.setCreateTime(new Date());
        detail.setModifyTime(new Date());
        detail.setRedRecordId(redRecordId);
        detail.setDeleted(0);
        return detail;
    }
}