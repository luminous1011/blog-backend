package com.inwe.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inwe.blog.dao.InformalEssayMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.utlis.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private InformalEssayMapper informalEssayMapper;



    @Test
    void contextLoads() {
//        List<Essay> essays = informalEssayMapper.selectList(null);
//        essays.forEach(System.out::println);
//        QueryWrapper<Essay> wrapper= new QueryWrapper<>();
//        Page<Essay> page = new Page<>(1,2);
//        Page<Essay> page1 = informalEssayMapper.selectPage(page, wrapper);
//        page1.getRecords();

//        System.out.println(page1.getRecords());
//        Map<String, Integer> stringIntegerMap = new HashMap<>();
//        stringIntegerMap.put("page",1);
//        stringIntegerMap.put("pageSize",2);
//        informalEssayMapper.getEssayList(stringIntegerMap).forEach(System.out::println);
//        Page<Object> page = PageHelper.startPage(1, 2);
//        List<Essay> essays = informalEssayMapper.selectList(null);
//        PageInfo<Essay> essayPageInfo = new PageInfo<>(essays);
//        System.out.println(essayPageInfo);
        System.out.println(Util.getUuid());

    }

}
