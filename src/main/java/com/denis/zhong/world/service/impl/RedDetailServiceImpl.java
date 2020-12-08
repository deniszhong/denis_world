package com.denis.zhong.world.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.denis.zhong.world.entity.RedDetail;
import com.denis.zhong.world.dao.RedDetailDao;
import com.denis.zhong.world.service.RedDetailService;
import com.denis.zhong.world.service.bo.RobRedPackageBO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 红包明细表(RedDetail)表服务实现类
 *
 * @author deniszhong
 * @since 2020-12-03 15:28:38
 */
@Service("redDetailService")
public class RedDetailServiceImpl implements RedDetailService {

    @Resource
    private RedDetailDao redDetailDao;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RedDetail queryById(Long id) {
        return this.redDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RedDetail> queryAllByLimit(int offset, int limit) {
        return this.redDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param redDetail 实例对象
     * @return 实例对象
     */
    @Override
    public RedDetail insert(RedDetail redDetail) {
        this.redDetailDao.insert(redDetail);
        return redDetail;
    }

    /**
     * 修改数据
     *
     * @param redDetail 实例对象
     * @return 实例对象
     */
    @Override
    public RedDetail update(RedDetail redDetail) {
        this.redDetailDao.update(redDetail);
        return this.queryById(redDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.redDetailDao.deleteById(id) > 0;
    }

    @Override
    public RedDetail robRedPackage(RobRedPackageBO bo) {
        JSONArray redDetailJsonArray =  (JSONArray)redisTemplate.opsForList().rightPop(bo.getRedRecordId().toString());
        return redDetailJsonArray.toJavaObject(RedDetail.class);
    }
}