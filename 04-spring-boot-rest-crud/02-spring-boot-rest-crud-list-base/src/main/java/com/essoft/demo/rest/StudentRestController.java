package com.essoft.demo.rest;

import com.essoft.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> students;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Ertan", "Sidar"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }


    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
}
