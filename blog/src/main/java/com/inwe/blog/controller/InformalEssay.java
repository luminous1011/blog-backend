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

    /**
     * 新增
     * @param essay
     * @return
     */
    @PostMapping("insertEssay")
    public R insertEssay(@RequestBody Essay essay){
        long temp = new Date().getTime(); // 获取当前时间戳
        Essay essayTemp = new Essay();
        essayTemp.setCreateTime(temp);  // 设置创建时间
        essayTemp.setUpdateTime(temp); // 新增时 创建时间即为 -> 更新时间
        System.out.println(essay);
        if(essay.getSource()==null){
            return R.error("来源不可为空！");
        }
        if(essay.getText()==null){
            return R.error("内容不可为空！");
        }
        essayTemp.setSource(essay.getSource());
        essayTemp.setText(essay.getText());
        int insert = informalEssayMapper.insert(essayTemp);
        if(insert!=1){
            return  R.error();
        }
        return R.ok("新增成功！");
    }
}
