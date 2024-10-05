package com.essoft.cruddemo.dao;

import com.essoft.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    // define field for entity manager
    private EntityManager entityManager;

    //inject entity manager for constructor injection

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName desc", Student.class);

        // return query result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :lastName", Student.class);

        // set query parameters
        query.setParameter("lastName", lastName);

        // return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student student = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();
        return numRowsDeleted;
    }
}
