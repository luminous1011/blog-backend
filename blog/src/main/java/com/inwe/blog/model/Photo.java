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
@TableName("tb_photos")
public class Photo {
    private String photoId;
    private String src;
    private String blankSrc;
    private Long createTime;
    private Long updateTime;
    private String desc;
}
