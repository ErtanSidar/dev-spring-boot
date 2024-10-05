package com.essoft.cruddemo;

import com.essoft.cruddemo.dao.StudentDao;
import com.essoft.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
//            createStudent(studentDao);
            createMultipleStudent(studentDao);
        };
    }

    private void createMultipleStudent(StudentDao studentDao) {
        // create multiple students
        System.out.println("Creating 3 students objects.....");
        Student student1 = new Student("John", "Doe", "johnl@doe.com");
        Student student2 = new Student("Mary", "Doe", "mary@doe.com");
        Student student3 = new Student("Ertan", "Sidar", "ertan@doe.com");

        // save the student objects
        System.out.println("Saving the students");
        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
    }

    private void createStudent(StudentDao studentDao) {
        //create a student object
        System.out.println("Creating a new student object.....");
        Student student = new Student("Paul", "Doe", "paul@doe.com");

        //saving the student
        System.out.println("Saving the student");
        studentDao.save(student);

        //display id of the  saved student
        System.out.println("Saved Student generated id: " + student.getId());
    }

}
