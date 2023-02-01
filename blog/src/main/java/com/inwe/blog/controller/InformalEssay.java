package com.inwe.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inwe.blog.dao.InformalEssayMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.utlis.R;
import net.sf.jsqlparser.util.validation.metadata.DatabaseException;
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
//        QueryWrapper<Essay> wrapper= new QueryWrapper<>();
//        Page<Essay> pageTemp = new Page<>(page,pageSize);
//        List<Essay> essays = informalEssayMapper.selectPage(pageTemp, wrapper).getRecords();
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("page",(page-1)*pageSize);
        stringIntegerMap.put("pageSize",pageSize);
        return R.ok().put("data", informalEssayMapper.getEssayList(stringIntegerMap)) ;
    }

    @PostMapping("insertEssay")
    public int insertEssay(@RequestBody Essay essay){
        long temp = new Date().getTime();
        Essay essayTemp = new Essay();
        essayTemp.setCreateTime(temp);
        essayTemp.setUpdateTime(temp);
        essayTemp.setSource(essay.getSource());
        essayTemp.setText(essay.getText());
        System.out.println(essay.getText());
        informalEssayMapper.insert(essayTemp);
        return 1;
    }
}
