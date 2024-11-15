package com.essoft.springboot.cruddemo.dao;

import com.essoft.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result
        List<Employee> employees = query.getResultList();

        return employees;
    }
}
