package com.inwe.blog.controller;

import com.inwe.blog.mapper.PageMapper;
import com.inwe.blog.model.Page;
import com.inwe.blog.utlis.R;
import com.inwe.blog.utlis.Util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/inwe/page/")
public class PageController {

    @Resource
    private PageMapper pageMapper;

    /**
     * 获取页面 时间 浏览量 评论量
     * @param path
     * @return
     */
    @GetMapping("getPageData")
    public R getPageDataById(String path){

        // 获取数据
        Page page = pageMapper.getPageDataByPath(path);
        System.out.println("获取页面数据："+page.toString());

        //获取数据成功后 即默认用户浏览过该页面/文章 浏览量+1
        int i = pageMapper.updateViewCountById(page.getPageId());
        System.out.println("页面:"+page.getName()+"路径"+page.getPath()+"浏览量+"+i);

        return  R.ok().put("data",page);
    }

    @GetMapping("insertPage")
    public R insertPage(Page page){
        page.setPageId(Util.getUuid()); // 主键id uuid 32位
        page.setUpdateTime(Util.getTime()); //  更新时间
        page.setCreateTime(Util.getTime()); //  创建时间
        page.setViewsCount(0); // 新建初始默认浏览量为 0
        page.setCommentsCount(0); // 新建初始评论量为 0
        pageMapper.insert(page);
        return  R.ok();
    }

}
