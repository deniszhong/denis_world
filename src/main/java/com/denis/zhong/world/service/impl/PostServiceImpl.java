package com.denis.zhong.world.service.impl;

import com.denis.zhong.world.mapper.entity.Post;
import com.denis.zhong.world.mapper.PostMapper;
import com.denis.zhong.world.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 帖子(Post)表服务实现类
 *
 * @author deniszhong
 * @since 2020-10-30 15:02:49
 */
@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Post queryById(Integer id) {
        return this.postMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Post> queryAllByLimit(int offset, int limit) {
        return this.postMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post insert(Post post) {
        this.postMapper.insert(post);
        return post;
    }

    /**
     * 修改数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post update(Post post) {
        this.postMapper.update(post);
        return this.queryById(post.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.postMapper.deleteById(id) > 0;
    }
}