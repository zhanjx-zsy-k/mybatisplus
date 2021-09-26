package com.atguigu.mp.metaObjectHandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author k
 * @create 2021-09-25 0:08
 */


public class MyMetaObjectHandler extends MetaObjectHandler {




    public void insertFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        if(name==null){
            System.out.println("*********插入操作满足填充条件**************");
            setFieldValByName("name","詹俊祥",metaObject);
        }
    }

    public void updateFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        if(name==null){
            System.out.println("*********修改操作满足填充条件**************");
            setFieldValByName("name","俊祥",metaObject);
        }
    }
}
