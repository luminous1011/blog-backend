package com.inwe.blog.mapper;

import com.inwe.blog.model.Essay;

import java.util.List;

public  interface EssayMapper {
    Integer deleteById(Integer id);
    List<Essay> getEssaysList();

    Integer insertOne(Essay essay);
}