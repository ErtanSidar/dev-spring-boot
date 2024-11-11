package com.essoft.springboot.cruddemo.service;

import com.essoft.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
