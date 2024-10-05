package com.essoft.cruddemo;

import com.essoft.cruddemo.dao.StudentDao;
import com.essoft.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
//            createStudent(studentDao);
//            createMultipleStudent(studentDao);
//            readStudent(studentDao);
//            queryForStudents(studentDao);
            queryForStudentsByLastName(studentDao);
        };
    }

    private void queryForStudentsByLastName(StudentDao studentDao) {
        // get a list of students
        List<Student> students = studentDao.findByLastName("sidar");

        // display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDao studentDao) {
        // get a list of students
        List<Student> students = studentDao.findAll();

        // display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDao studentDao) {
        // create a student object
        System.out.println("Creating a new student object.....");
        Student student = new Student("Ertan", "Sidar", "ertan@doe.com");

        // save the student
        System.out.println("Saving the student");
        studentDao.save(student);

        // display id of the saved student
        int id = student.getId();
        System.out.println("Saved student. Generated id :" + id);

        // retrieve student based on the id : primary key
        System.out.println("Retrieving student with id :" + id);
        Student myStudent = studentDao.findById(student.getId());

        // display the student
        System.out.println("Found the student :" + myStudent);

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
