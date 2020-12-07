package com.denis.zhong.world.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 红包记录表(RedRecord)实体类
 *
 * @author deniszhong
 * @since 2020-12-03 15:10:27
 */
public class RedRecord implements Serializable {
    private static final long serialVersionUID = 556424627245784558L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 发红包用户
    */
    private Integer userId;
    /**
    * 红包金额
    */
    private Integer amount;
    /**
    * 红包个数
    */
    private Integer num;
    
    private Integer deleted;
    
    private Date createTime;
    
    private Date modifyTime;
    /**
    * 红包唯一标识
    */
    private String redPackage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getRedPackage() {
        return redPackage;
    }

    public void setRedPackage(String redPackage) {
        this.redPackage = redPackage;
    }

}