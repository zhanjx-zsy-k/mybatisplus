package com.atguigu.mp.test;


import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
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

    @Test
    public void testPage(){
        Page<Employee> page = new Page<Employee>(2, 2);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        System.out.println(employees);
        System.out.println("总记录"+page.getTotal());
        System.out.println("总页码"+page.getPages());
        System.out.println("每页记录数"+page.getSize());

        page.setRecords(employees);
    }

}
