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
@AllArgsConstructor
@ToString
@TableName("tb_informal_essay")
public class Essay {
   @TableId(value = "infoId",type = IdType.AUTO)
   private Integer  infoId;
   private String text;
   private String source;
   private String url;
   private long createTime;
   private long updateTime;
}
