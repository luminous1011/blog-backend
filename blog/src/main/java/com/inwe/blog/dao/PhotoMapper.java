package com.inwe.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.Photo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {
}
