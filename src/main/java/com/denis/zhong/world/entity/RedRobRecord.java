package com.denis.zhong.world.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 抢红包记录表(RedRobRecord)实体类
 *
 * @author deniszhong
 * @since 2020-12-03 15:29:02
 */
public class RedRobRecord implements Serializable {
    private static final long serialVersionUID = -26049381459642008L;
    
    private Long id;
    /**
    * 红包记录表
    */
    private Long redRecordId;
    
    private Long recordDetailId;
    /**
    * 抢中红包者
    */
    private Integer userId;
    
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

    public Long getRecordDetailId() {
        return recordDetailId;
    }

    public void setRecordDetailId(Long recordDetailId) {
        this.recordDetailId = recordDetailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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