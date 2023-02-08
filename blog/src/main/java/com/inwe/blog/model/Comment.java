package com.inwe.blog.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_comment")
public class Comment {
    private String cid;
    private String fromUid;
    private String toUid;
    private String replyType;
    private String replyId;
    private  String content;
    private  long createTime;
    private String operatingSystem;
    private  String browser;
    private String browserIcon;
    private  String path;
    @TableField(exist = false)
    private User fromUser;
    @TableField(exist = false)
    private User replyUser;
    @TableField(exist = false)
    private List<Comment> children;
}
