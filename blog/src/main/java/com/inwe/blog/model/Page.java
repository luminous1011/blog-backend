package com.inwe.blog.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@TableName("tb_pages")
public class Page {
    @TableId(value="page_id",type = IdType.INPUT)
    private String pageId; // 页面id
    private String path; // 页面路由
    private String name; // 页面名称
    private int commentsCount; // 评论量
    private int viewsCount; // 浏览量
    private  long createTime;
    private  long updateTime;

}
