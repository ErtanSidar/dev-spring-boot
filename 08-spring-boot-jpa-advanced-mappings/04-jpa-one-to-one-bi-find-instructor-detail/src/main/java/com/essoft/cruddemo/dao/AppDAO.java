package com.essoft.cruddemo.dao;

import com.essoft.cruddemo.entity.Instructor;
import com.essoft.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

}
