package com.atguigu.mp.test;


import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.beans.User;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.mapper.UserMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * @author k
 * @create 2021-09-24 17:19
 */
public class TestMP {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("aplicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
    private UserMapper userMapper = ioc.getBean("userMapper",UserMapper .class);


    @Test
    public void testMetaObjectHandler(){
        User user = new User();
        user.setLogicFlag(1);
//        user.setName("tom");
        user.setId(5);
        userMapper.updateById(user);

    }

    @Test
    public void testMysqlInject(){
        int i = employeeMapper.deleteAll();
        System.out.println(i);
    }


    @Test
    public void tesetLogicDelete(){
//        Integer integer = userMapper.deleteById(1);
//        System.out.println(integer);

        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
