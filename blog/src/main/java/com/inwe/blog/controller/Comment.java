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

import java.util.*;

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
    @PostMapping("replyComment")
    public R replyComment(@RequestBody Map<String,String> map){
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
        return R.ok();
    }
    @GetMapping ("getCommentsList")
    public R getCommentsList(String replyType){
        List<com.inwe.blog.model.Comment> data = getCommentList("comment");
        return R.ok().put("data",data);
    }
    public List<com.inwe.blog.model.Comment> getCommentReplyList(com.inwe.blog.model.Comment comment){
        HashMap<String, Object> map = new HashMap<>();
        map.put("from_uid",comment.getFromUid());
        map.put("reply_type","reply");
        return commentMapper.selectByMap(map);
    }
    public List<com.inwe.blog.model.Comment> getCommentList(String replyType){
        List<com.inwe.blog.model.Comment> data = commentMapper.getCommentList(replyType);
        data.forEach((com.inwe.blog.model.Comment comment)->{
            comment.setFromUser(userMapper.selectById(comment.getFromUid()));
            comment.setReplyUser(userMapper.selectById(comment.getReplyId()));
            comment.setChildren(getCommentReplyList(comment));
            System.out.println(comment);
            System.out.println(getCommentReplyList(comment));
        });
        return  data;
    }

    public String insertUser(Map<String,String> map){
        String hasUser = isHasUser(map);
        if(hasUser!=null){
            return hasUser;
        }
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
    public String isHasUser(Map<String,String> map){
        Map<String, String> temp = new HashMap<>();
        temp.put("username",map.get("name"));
        temp.put("email",map.get("email"));
        List<User> users = userMapper.selectUidByNameEmail(temp);
        if(users.size()==0){
            return  null;
        }else{
            return users.get(0).getUid();
        }
    }
}
