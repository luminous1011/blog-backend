package com.inwe.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.inwe.blog.dao.CommentMapper;
import com.inwe.blog.dao.UserMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.model.User;
import com.inwe.blog.utlis.R;
import com.inwe.blog.utlis.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static net.sf.jsqlparser.parser.feature.Feature.insert;

@RestController
@RequestMapping("/inwe/comment/")
public class Comment {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @PostMapping ("addComment")
    public R addComment(@RequestBody Map<String,String> map){
        System.out.println(map);
        String uid = insertUser(map);
        long temp = new Date().getTime();
        com.inwe.blog.model.Comment comment=new com.inwe.blog.model.Comment();
        comment.setCid(Util.getUuid());
        comment.setFromUid(uid);
        comment.setReplyType(map.get("replyType"));
        comment.setToUid(map.get("toUid"));
        comment.setReplyId(map.get("replyId"));
        comment.setOperatingSystem(map.get("system"));
        comment.setCreateTime(temp);
        comment.setBrowser(map.get("browser"));
        comment.setBrowserIcon(map.get("browserIcon"));
        comment.setContent(map.get("comments"));
        comment.setPath(map.get("path"));
        commentMapper.insert(comment);
        return  R.ok();
    }
    @GetMapping ("getCommentsList")
    public R getCommentsList(){
        List<com.inwe.blog.model.Comment> data = commentMapper.selectList(Wrappers.<com.inwe.blog.model.Comment>query().orderByDesc("create_time"));
        return R.ok().put("data",data);
    }

    public String insertUser(Map<String,String> map){
        User user = new User();
        user.setUid(Util.getUuid());
        user.setUsername(map.get("name"));
        user.setEmail(map.get("email"));
        user.setBlogUrl(map.get("blogUrl"));
        int insert = userMapper.insert(user);
        if(insert==1){
            return user.getUid();
        }
        return null;
    }
}
