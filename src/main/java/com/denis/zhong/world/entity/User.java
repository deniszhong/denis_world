package com.denis.zhong.world.entity;

import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author deniszhong
 * @since 2020-11-19 15:27:00
 */
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -65722822249244632L;
    
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 是否删除
    */
    private Integer deleted;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date modifyTime;

    private String password;

    private int roleId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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