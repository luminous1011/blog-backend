package com.inwe.blog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.SysexMessage;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.inwe.blog.utlis.R;
import com.inwe.blog.utlis.Util;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class UploadPicture {
//    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy.MM.dd/");
//
//    @Value("${file-save-path}")
//    private String fileSavePath;
    @Value("${aliyun.oss.file.endpoint}")
    String endpoint;

    @Value("${aliyun.oss.file.keyid}")
    String accessKeyId;

    @Value("${aliyun.oss.file.keysecret}")
    String accessKeySecret;

    @Value("${aliyun.oss.file.bucketname}")
    String bucketName;

    @Autowired
    OSS ossClient;
    @PostMapping("/upload/img")
    public R fileupload(MultipartFile file, HttpServletRequest req){
        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        // 根据文件名获取文件后缀格式
        String[] split = originalFilename.split("\\.");
        String type= split[split.length-1];
        String[] imgTypes={"webp","tif","jpeg","svg","png","raw","gif","jpg"};// 常用图片格式

        // 判断图片类型是否规范
        if(!Arrays.asList(imgTypes).contains(type)) {
            return R.error("文件类型不对");
        }

        String newName= Util.getUuid() + "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"." + type;
        System.out.println("newName"+newName);
        // 创建实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        Map<String,Object> result = new HashMap<>();

        try {
            ossClient.putObject(bucketName,newName,file.getInputStream());
            String url = "https://" + bucketName + "." + endpoint + "/" + newName;
            result.put("url", url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//
//        Map<String,Object> result = new HashMap<>();
//        //获取文件的名字
//        String originName = file.getOriginalFilename();
//        System.out.println("originName:"+originName);
//
//        String[] split = originName.split("\\.");
//
//        String type= split[split.length-1];
//        String[] imgTypes={"webp","tif","jpeg","svg","png","raw","gif"};
//        // 判断文件类型
//        if(!Arrays.asList(imgTypes).contains(type)) {
//            return R.error("文件类型不对");
//        }
//        //给上传的文件新建目录
//        String format = sdf.format(new Date());
//        String realPath = fileSavePath + format;
//        System.out.println("realPath:"+realPath);
//        //若目录不存在则创建目录
//        File folder = new File(realPath);
//        if(! folder.exists()) {
//            folder.mkdirs();
//        }
//        //给上传文件取新的名字，避免重名
//        String newName = UUID.randomUUID().toString() + "." + type;
//        try {
//            //生成文件，folder为文件目录，newName为文件名
//            file.transferTo(new File(folder,newName));
//            //生成返回给前端的url
//            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +"/images"+ format + newName;
//            System.out.println("url:"+url);
//            //返回URL
//            result.put("url", url);
//        }catch (IOException e) {
//            // TODO Auto-generated catch block
//            result.put("message",e.getMessage());
//        }
        return R.ok(result);

    }
}
