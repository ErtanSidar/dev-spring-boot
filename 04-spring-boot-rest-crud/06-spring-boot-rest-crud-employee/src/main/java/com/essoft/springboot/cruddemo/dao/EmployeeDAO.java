package com.essoft.springboot.cruddemo.dao;

import com.essoft.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
