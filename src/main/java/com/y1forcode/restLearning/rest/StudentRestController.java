package com.y1forcode.restLearning.rest;


import com.y1forcode.restLearning.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
   private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("ramiz" ,"KARAESKI"));
        theStudents.add(new Student("ezel","bayraktar"));
        theStudents.add(new Student("Ganyotcu"," "));
    }

    // define endpoint for "/students" return a list of students
    @GetMapping("/student")
    public List<Student> getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list

        // check the student id again the list size
        if ((studentId >=theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("adami bulamadi dayiii : " + studentId);
        }
        return theStudents.get(studentId);
    }

    // add an exception handler usin @exceptionhandler




}
