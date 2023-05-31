package com.inwe.blog.service.impl;

import com.inwe.blog.mapper.EssayMapper;
import com.inwe.blog.model.Essay;
import com.inwe.blog.service.EssayService;
import com.inwe.blog.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EssayServiceImpl implements EssayService {
    @Autowired
    private EssayMapper essayMapper;

    @Override
    public List<Essay> getEssaysList(){
        return essayMapper.getEssaysList();
    }
    @Override
    public R deleteById(Integer id){
        Integer res = essayMapper.deleteById(id);
        if(res==1){
            return R.ok("删除成功！");
        }

        return R.error("删除失败");
    }

    @Override
    public R insertOne(Essay essay){
        System.out.println(essay+"222***************************");
        long temp = new Date().getTime(); // 获取当前时间戳
        Essay essayTemp = new Essay();
        essayTemp.setCreateTime(temp);  // 设置创建时间
        essayTemp.setUpdateTime(temp); // 新增时 创建时间即为 -> 更新时间
        essayTemp.setSource(essay.getSource());
        essayTemp.setText(essay.getText());
        essayTemp.setUrl(essay.getUrl());
        System.out.println(essay);
        if(essayMapper.insertOne(essayTemp)!=1){
            return  R.error();
        }
        return R.ok("新增成功！");
    } ;
}
