package com.inwe.blog.utlis;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String,Object>{
    public R(){
        put("code",0);
        put("message","success");
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
