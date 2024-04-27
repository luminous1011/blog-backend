package com.inwe.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.Mongotemplate;
@SpringBootTest
public class MongoTest {
    private final Mongotemplate mongotemplate;

    @Autowired
    public MongoTest(Mongotemplate mongotemplate){
        this.mongotemplate=mongotemplate;
    }

}
