package com.inwe.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@TableName("tb_user")
public class User {
    private String uid;
    private String username;
    private String email;
    private String blogUrl;
    private String avatar;
}
