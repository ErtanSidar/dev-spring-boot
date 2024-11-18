package com.essoft.cruddemo.dao;

import com.essoft.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

}
