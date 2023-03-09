package com.inwe.blog.utlis;

import java.util.Date;
import java.util.UUID;

public class Util {
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static Long getTime(){
        return new Date().getTime();
    }
}
