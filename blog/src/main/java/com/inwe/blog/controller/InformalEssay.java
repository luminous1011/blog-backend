package com.inwe.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inwe.blog.dao.InformalEssayMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/inwe/essay/")
public class InformalEssay {

    @Autowired
    InformalEssayMapper informalEssayMapper;

    @GetMapping("getEssayList")
    public R getEssayList(int page,int pageSize){
        PageHelper.startPage(page, pageSize);
        List<Essay> essays = informalEssayMapper.getEssayList();
        PageInfo<Essay> essayPageInfo = new PageInfo<>(essays);
        return R.ok().put("data", essayPageInfo) ;
    }

    @PostMapping("insertEssay")
    public R insertEssay(@RequestBody Essay essay){
        long temp = new Date().getTime();
        Essay essayTemp = new Essay();
        essayTemp.setCreateTime(temp);
        essayTemp.setUpdateTime(temp);
        essayTemp.setSource(essay.getSource());
        essayTemp.setText(essay.getText());
        informalEssayMapper.insert(essayTemp);
        return R.ok();
    }
}
