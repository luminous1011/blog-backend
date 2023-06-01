package com.inwe.blog.service;

import com.inwe.blog.model.Essay;
import com.inwe.blog.utlis.R;

import java.util.List;

public interface EssayService {
    R deleteById(Integer id);
    List<Essay> getEssaysList();

    R insertOne(Essay essay);

    R updateById(Essay essay);

    R deleteByIds(Integer[] ids);
}
