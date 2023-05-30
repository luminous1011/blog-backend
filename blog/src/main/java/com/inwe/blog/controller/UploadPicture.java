package com.inwe.blog.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.SysexMessage;

import com.inwe.blog.utlis.R;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class UploadPicture {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy.MM.dd/");

    @Value("${file-save-path}")
    private String fileSavePath;

    @PostMapping("/upload/img")
    public R fileupload(MultipartFile file, HttpServletRequest req){

        Map<String,Object> result = new HashMap<>();
        //获取文件的名字
        String originName = file.getOriginalFilename();
        System.out.println("originName:"+originName);

        String[] split = originName.split("\\.");

        String type= split[split.length-1];
        String[] imgTypes={"webp","tif","jpeg","svg","png","raw","gif"};
        // 判断文件类型
        if(!Arrays.asList(imgTypes).contains(type)) {
            return R.error("文件类型不对");
        }
        //给上传的文件新建目录
        String format = sdf.format(new Date());
        String realPath = fileSavePath + format;
        System.out.println("realPath:"+realPath);
        //若目录不存在则创建目录
        File folder = new File(realPath);
        if(! folder.exists()) {
            folder.mkdirs();
        }
        //给上传文件取新的名字，避免重名
        String newName = UUID.randomUUID().toString() + "." + type;
        try {
            //生成文件，folder为文件目录，newName为文件名
            file.transferTo(new File(folder,newName));
            //生成返回给前端的url
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +"/images"+ format + newName;
            System.out.println("url:"+url);
            //返回URL
            result.put("url", url);
        }catch (IOException e) {
            // TODO Auto-generated catch block
            result.put("message",e.getMessage());
        }
        return R.ok(result);

    }
}
