package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysUserPost;

/**
 * 用户与岗位关联表 数据层
 *
 * @author ruoyi
 */
public interface SysUserPostMapper {
    /**
     * 通过用户ID --删除-- 用户和岗位关联
     */
    int deleteUserPostByUserId(Long userId);

    /**
     * 通过岗位ID 查询 岗位使用数量
     */
    int countUserPostById(Long postId);

    /**
     * --批量删除-- 用户和岗位关联
     */
    int deleteUserPost(Long[] ids);

    /**
     * ++批量新增++ 用户岗位信息
     */
    int batchUserPost(List<SysUserPost> userPostList);
}
