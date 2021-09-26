package com.atguigu.mp.test;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @author k
 * @create 2021-09-24 17:19
 */
public class TestMP {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("aplicationContext.xml");


    @Test
    public void testARUpdate(){
        Employee employee = new Employee();
        employee.setId(12);
        employee.setLastName("宋老送");
        employee.setEmail("送@qq.com");
        employee.setAge(32);
        employee.setGender(1);
        boolean b = employee.updateById();
        System.out.println(b);
    }

    @Test
    public void testARInsert(){
        Employee employee = new Employee();
        employee.setLastName("宋老师");
        employee.setEmail("送@qq.com");
        employee.setAge(35);
        employee.setGender(1);

        boolean insert = employee.insert();
        System.out.println(insert);
    }

}
