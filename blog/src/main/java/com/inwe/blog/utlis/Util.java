package com.inwe.blog.utlis;

import java.util.UUID;

public class Util {
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
