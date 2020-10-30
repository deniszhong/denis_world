package com.denis.zhong.world.controller;

import com.denis.zhong.world.mapper.entity.Post;
import com.denis.zhong.world.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 帖子(Post)表控制层
 *
 * @author deniszhong
 * @since 2020-10-30 15:02:49
 */
@RestController
@RequestMapping("post")
public class PostController {
    /**
     * 服务对象
     */
    @Resource
    private PostService postService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Post selectOne(Integer id) {
        return this.postService.queryById(id);
    }

}