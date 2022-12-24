package com.example.website2.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
//        System.out.println(metaObject);
        if (metaObject.hasGetter("createBy")){
//            this.setFieldValByName("createBy", authUser.getUsername(), metaObject);
            this.setFieldValByName("createBy", "yes", metaObject);
        }
        if (metaObject.hasGetter("updateTime")){
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
