package com.inwe.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inwe.blog.model.Essay;
import com.inwe.blog.service.EssayService;
import com.inwe.blog.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/inwe/essay/")
public class InformalEssay {

    @Autowired
  private EssayService essayService;

    @GetMapping("getEssayList")
    public R getEssayList(int page,int pageSize){
        PageHelper.startPage(page, pageSize);
        List<Essay> essays = essayService.getEssaysList();
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
        if(essay.getSource()==null){
            return R.error("来源不可为空！");
        }
        if(essay.getText()==null){
            return R.error("内容不可为空！");
        }
        return essayService.insertOne(essay);
    }

    /*
    * 根据 id 删除
    * */
    @DeleteMapping("deleteById/{id}")
    public R deleteEssayById(@PathVariable("id") Integer id){
        return  essayService.deleteById(id);
    }
    @DeleteMapping("deleteByIds")
    public R deleteEssayById(@RequestBody HashMap<String,Object> hashMap){
        Object ids = hashMap.get("ids");
        Integer[] tranfer = (Integer[]) ids;
        System.out.println(tranfer);
        return  R.ok();
    }
    @PutMapping("updateById")
    public R updateById(@RequestBody Essay essay){
        return essayService.updateById(essay);
    }
}
