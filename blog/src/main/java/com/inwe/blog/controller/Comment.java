package com.inwe.blog.controller;

import com.inwe.blog.dao.CommentMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/inwe/comment/")
public class Comment {

    @Autowired
    CommentMapper commentMapper;

    @PostMapping ("addComment")
    public R addComment(@RequestBody com.inwe.blog.model.Comment comment){
        long temp = new Date().getTime();
        com.inwe.blog.model.Comment commentTemp = new com.inwe.blog.model.Comment();
        commentTemp.setComments(comment.getComments());
        commentTemp.setCommentName(comment.getCommentName());
        commentTemp.setCommentEmail(comment.getCommentEmail());
        commentTemp.setBlogUrl(comment.getBlogUrl());
        commentTemp.setPath(comment.getPath());
        commentTemp.setBrowser(comment.getBrowser());
        commentTemp.setBrowserIcon(comment.getBrowserIcon());
        commentTemp.setCreateTime(temp);
        commentTemp.setOperatingSystem(comment.getOperatingSystem());
        commentTemp.setReplyId(0);
//        essayTemp.setCreateTime(temp);
//        essayTemp.setUpdateTime(temp);
//        essayTemp.setSource(essay.getSource());
//        essayTemp.setText(essay.getText());
        commentMapper.insert(commentTemp);
        return  R.ok();
    }
}
