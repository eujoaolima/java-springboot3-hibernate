package com.restcrudapi.demo.rest;

import com.restcrudapi.demo.entity.Student;
import com.restcrudapi.demo.rest.exception.StudentErrorResponse;
import com.restcrudapi.demo.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> theStudents;

    @PostConstruct
    public void save() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Batata", "batata"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        if (id >= theStudents.size() || id < 0) {
            throw new StudentNotFoundException("Student not found: " + id);
        }
        return theStudents.get(id);
    }
}
