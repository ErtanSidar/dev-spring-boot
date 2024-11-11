package com.essoft.springboot.cruddemo.rest;

import com.essoft.springboot.cruddemo.entity.Employee;
import com.essoft.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty : inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employee" and return list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void delete(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
    }

}
