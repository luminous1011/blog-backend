package com.inwe.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_comment_main")
public class Comment {
    private String commentId;
    private String commentName;
    private  String commentEmail;
    private  String blogUrl;
    private  String comments;
    private  long createTime;
    private String operatingSystem;
    private  String browser;
    private String browserIcon;
    private  String path;
}
