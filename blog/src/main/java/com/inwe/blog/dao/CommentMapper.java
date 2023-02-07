package com.inwe.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("SELECT cid,from_uid,content,create_time,browser_icon,operating_system,path,browser,to_uid,reply_type,reply_id" +
            "from tb_comment order by create_time desc")
    public List<Comment> getCommentList();
}
