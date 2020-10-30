package com.denis.zhong.world.mapper.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 帖子(Post)实体类
 *
 * @author deniszhong
 * @since 2020-10-30 15:02:49
 */
public class Post implements Serializable {
    private static final long serialVersionUID = 439176520836727448L;
    
    private Integer id;
    
    private Integer topicId;
    
    private String content;
    
    private Date createtime;
    
    private Date modifytime;
    
    private Integer deleted;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

}