package com.inwe.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inwe.blog.dao.CommentMapper;
import com.inwe.blog.dao.UserMapper;
import com.inwe.blog.mapper.PageMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.model.User;
import com.inwe.blog.utlis.R;
import com.inwe.blog.utlis.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/inwe/comment/")
public class Comment {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    /*
     * 新增评论
     * */
    @PostMapping ("addComment")
    public R addComment(@RequestBody Map<String,String> map){
        String uid = insertUser(map);
        insertComment(uid,map);
        return  R.ok();
    }
    /*
     * 回复评论
     * */
    @PostMapping("replyComment")
    public R replyComment(@RequestBody Map<String,String> map){
        String uid = insertUser(map);
        insertComment(uid,map);
        return R.ok();
    }
    /*
     * 获取comment列表
     * */
    @GetMapping ("getCommentsList")
    public R getCommentsList(String path,int page,int pageSize){
        PageInfo<com.inwe.blog.model.Comment> data = getCommentList("comment",path, page, pageSize);
        return R.ok().put("data",data);
    }
    public List<com.inwe.blog.model.Comment> getCommentReplyList(com.inwe.blog.model.Comment commentVar){
        HashMap<String, String> map = new HashMap<>();
        map.put("from_cid",commentVar.getCid());
        map.put("reply_type","reply");
        List<com.inwe.blog.model.Comment> comments = commentMapper.getReplyList(map);
        comments.forEach((com.inwe.blog.model.Comment comment)->{
            comment.setFromUser(userMapper.selectById(comment.getFromUid()));
            comment.setReplyUser(userMapper.selectById(comment.getReplyId()));
        });
        return comments;
    }

    public PageInfo getCommentList(String replyType,String path,int page,int pageSize){
        PageHelper.startPage(page, pageSize);
        List<com.inwe.blog.model.Comment> data = commentMapper.getCommentList(replyType,path);
        data.forEach((com.inwe.blog.model.Comment comment)->{
            comment.setFromUser(userMapper.selectById(comment.getFromUid()));
            comment.setChildren(getCommentReplyList(comment));
        });
        return  new PageInfo<>(data);
    }

    /*
    * 新增 user
    * */
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

    /*
    * 根据
    * username 与 email
    * 字段判断是否存在 user
    * */
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

    public void insertComment(String uid,Map<String,String> map){
        long temp = new Date().getTime();
        com.inwe.blog.model.Comment comment=new com.inwe.blog.model.Comment();
        comment.setCid(Util.getUuid());
        comment.setFromUid(uid);
        comment.setReplyType(map.get("replyType"));
        comment.setFromCid(map.get("fromCid"));
        comment.setReplyId(map.get("replyId"));
        comment.setOperatingSystem(map.get("system"));
        comment.setCreateTime(temp);
        comment.setBrowser(map.get("browser"));
        comment.setBrowserIcon(map.get("browserIcon"));
        comment.setContent(map.get("comments"));
        comment.setPath(map.get("path"));
        commentMapper.insert(comment);
    }
}
