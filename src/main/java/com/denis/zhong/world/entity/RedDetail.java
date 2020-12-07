package com.denis.zhong.world.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 红包明细表(RedDetail)实体类
 *
 * @author deniszhong
 * @since 2020-12-03 15:28:38
 */
public class RedDetail implements Serializable {
    private static final long serialVersionUID = -74832706142500901L;
    
    private Long id;
    /**
    * 红包记录id
    */
    private Long redRecordId;
    /**
    * 单个红包金额 单位分
    */
    private Integer redPerAmount;
    
    private Integer deleted;
    
    private Date createTime;
    
    private Date modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRedRecordId() {
        return redRecordId;
    }

    public void setRedRecordId(Long redRecordId) {
        this.redRecordId = redRecordId;
    }

    public Integer getRedPerAmount() {
        return redPerAmount;
    }

    public void setRedPerAmount(Integer redPerAmount) {
        this.redPerAmount = redPerAmount;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}