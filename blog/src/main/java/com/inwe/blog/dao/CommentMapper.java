package com.inwe.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
