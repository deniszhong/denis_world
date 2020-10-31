package com.denis.zhong.world.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 主题(Topic)实体类
 *
 * @author deniszhong
 * @since 2020-10-31 14:50:38
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = 750856772934427645L;
    
    private Integer id;
    /**
    * 主题
    */
    private String title;
    /**
    * 是否删除
    */
    private Integer deleted;
    /**
    * 创建时间
    */
    private Date createtime;
    
    private Date modifytime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

}