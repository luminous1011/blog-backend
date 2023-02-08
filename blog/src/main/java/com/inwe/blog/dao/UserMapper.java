package com.inwe.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select uid from tb_user where username=#{username} and email=#{email}")
    public List<User> selectUidByNameEmail(Map<String,String> map);
}
