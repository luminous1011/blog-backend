package com.inwe.blog;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.inwe.blog.dao.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class BlogApplicationTests {
    @Value("${aliyun.oss.file.endpoint}")
    String endpoint;

    @Value("${aliyun.oss.file.keyid}")
    String accessKeyId;
    @Value("${aliyun.oss.file.keysecret}")
    String accessKeySecret;
    @Value("${aliyun.oss.file.bucketname}")
    String bucketName;
    @Autowired
    private InformalEssayMapper informalEssayMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    OSS ossClient;


    @Test
    void upload() throws FileNotFoundException{
        String dir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        // 创建OSSClient实例。
        System.out.println(bucketName);
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName,dir+"3.png",new FileInputStream("C:\\Users\\luminous\\Desktop\\1.png"));
//        ossClient.putObject("luminous1011","dev.png",
//                new FileInputStream("C:\\Users\\luminous\\Desktop\\1.png"));
//        System.out.println("success");

    }

    @Test
    void contextLoads() {
//        List<Essay> essays = informalEssayMapper.selectList(null);
//        essays.forEach(System.out::println);
//        QueryWrapper<Essay> wrapper= new QueryWrapper<>();
//        Page<Essay> page = new Page<>(1,2);
//        Page<Essay> page1 = informalEssayMapper.selectPage(page, wrapper);
//        page1.getRecords();

//        System.out.println(page1.getRecords());
//        Map<String, Integer> stringIntegerMap = new HashMap<>();
//        stringIntegerMap.put("page",1);
//        stringIntegerMap.put("pageSize",2);
//        informalEssayMapper.getEssayList(stringIntegerMap).forEach(System.out::println);
//        Page<Object> page = PageHelper.startPage(1, 2);
//        List<Essay> essays = informalEssayMapper.selectList(null);
//        PageInfo<Essay> essayPageInfo = new PageInfo<>(essays);
//        System.out.println(essayPageInfo);

//        System.out.println(commentMapper.selectList(Wrappers.<Comment>query().orderByDesc("create_time")));

//        System.out.println(commentMapper.getCommentList("comment"));
    }

}
