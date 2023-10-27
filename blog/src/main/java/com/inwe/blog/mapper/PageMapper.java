package com.inwe.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper extends BaseMapper<Page> {
   Page getPageDataByPath(String path);


   int updateViewCountById(String pageId);

   int updateCommentCountById(String id);
}
