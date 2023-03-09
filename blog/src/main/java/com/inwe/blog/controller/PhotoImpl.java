package com.inwe.blog.controller;

import com.inwe.blog.dao.PhotoMapper;
import com.inwe.blog.model.Photo;
import com.inwe.blog.utlis.R;
import com.inwe.blog.utlis.Util;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inwe/photo/")
public class PhotoImpl {

    PhotoMapper photoMapper;

    @GetMapping("list")
    public R getPhotoList(){
        List<com.inwe.blog.model.Photo> photos = photoMapper.selectList(null);
        System.out.println(photos);
        return R.ok().put("data",photos);
    }

    @PostMapping("insert")
    public R insertPhoto(@RequestBody Photo photo){
        photo.setPhotoId(Util.getUuid());
        photo.setCreateTime(Util.getTime());
        photo.setUpdateTime(Util.getTime());
        System.out.println(photo);
        photoMapper.insert(photo);
        return R.ok();
    }
}
