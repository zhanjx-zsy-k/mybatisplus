package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author k
 * @create 2021-09-24 17:32
 */
public interface EmployeeMapper extends BaseMapper<Employee> {


    int deleteAll(Integer id);
}
