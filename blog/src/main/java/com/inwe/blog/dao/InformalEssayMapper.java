package com.inwe.blog.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inwe.blog.model.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface InformalEssayMapper extends BaseMapper<Essay> {

    @Select("SELECT info_id,text,source ,create_time,update_time " +
            "from tb_informal_essay order by update_time desc")
    public List<Essay> getEssayList();
}
