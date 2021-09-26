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
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);


    @Test
    public void testEntityWrapperSelect(){
        //我们需要分页查询 tbl_employee 表中，年龄在 18~50 之间性别为男且
        //姓名为 xx 的所有用户

        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>()
                .between("age", 18, 50)
                .eq("gender", 1)
                .eq("last_name", "tom"));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }


    @Test
    public void testCommonSelect(){
//        Employee employee = employeeMapper.selectById(7);
//        System.out.println(employee);

//        Employee employee = new Employee();
//        employee.setId(7);
//        employee.setLastName("tom");
//        Employee employee1 = employeeMapper.selectOne(employee);
//        System.out.println(employee1);

//        List<Integer> list = new ArrayList<Integer>();
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        List<Employee> employees = employeeMapper.selectBatchIds(list);
//        System.out.println(employees);

//        Map<String, Object> columnMap = new HashMap<String, Object>();
//        columnMap.put("last_name" , "tom");
//        columnMap.put("gender" , "1");
//
//
//        List<Employee> employees = employeeMapper.selectByMap(columnMap);
//        System.out.println(employees);

        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(3, 2), null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }


    @Test
    public void testCommonUpdate(){
        Employee employee = new Employee();
        employee.setId(7);
        employee.setLastName("tom");
        employee.setEmail("tom@qq.com");
        employee.setGender(0);
//        employee.setAge(77);

//        Integer integer = employeeMapper.updateById(employee);
        Integer integer = employeeMapper.updateAllColumnById(employee);

        System.out.println("resulit" + integer);
    }


    @Test
    public void testCommonInsert(){
        Employee employee = new Employee();
        employee.setLastName("mp");
        employee.setAge(22);
//        employee.setEmail("mp@qq.com");
//        employee.setGender(1);
        employee.setSalary(20000.0);
//        Integer insert = employeeMapper.insert(employee);
        Integer insert = employeeMapper.insertAllColumn(employee);

        System.out.println(insert);


        Integer id = employee.getId();
        System.out.println("id:"+id);
    }


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ioc.getBean("dataSource",DataSource.class);

//        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
