package com.inwe.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inwe.blog.mapper.EssayMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.utlis.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/inwe/essay/")
public class EssayController {

    @Resource
    private EssayMapper essayMapper;

    /**
     * 随笔列表 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("getEssayList")
    public R getEssayList(int page,int pageSize){
        PageHelper.startPage(page, pageSize);
        List<Essay> essays = essayMapper.getEssaysList();
        PageInfo<Essay> essayPageInfo = new PageInfo<>(essays);
        return R.ok().put("data", essayPageInfo) ;
    }

}
