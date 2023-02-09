package com.inwe.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("SELECT cid,from_uid,content,create_time,browser_icon,operating_system,path,browser,from_cid,reply_type,reply_id from tb_comment where reply_type=#{reply_type} order by create_time desc ")
    public List<Comment> getCommentList(String reply_type);

    @Select("select cid,from_uid,content,create_time,browser_icon,operating_system,path,browser,from_cid,reply_type,reply_id from tb_comment where reply_type=#{reply_type} and from_cid=#{from_cid} order by create_time desc  ")
    public List<Comment> getReplyList(Map<String,String> map);
}
