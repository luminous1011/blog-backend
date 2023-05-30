package com.inwe.blog.controller;

import com.github.pagehelper.PageInfo;
import com.inwe.blog.dao.EssaySourceMapper;
import com.inwe.blog.model.Comment;
import com.inwe.blog.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inwe/essaysource/")
public class EssaySource {
    @Autowired
    EssaySourceMapper essaySourceMapper;

    @GetMapping("selectAll")
    public R selectALL(){
        List<com.inwe.blog.model.EssaySource> essaySources = essaySourceMapper.selectList(null);
        return R.ok().put("data",essaySources);
    }
    @PostMapping("insert")
    public R insert(com.inwe.blog.model.EssaySource essaySource){
        System.out.println(essaySource);
//        return R.ok().put("data",);
        return R.ok();
    }
}
