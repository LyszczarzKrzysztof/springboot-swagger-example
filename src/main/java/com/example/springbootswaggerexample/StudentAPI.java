package com.example.springbootswaggerexample;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {
    private List<Student> studentList;

    public StudentAPI() {
        this.studentList = Arrays.asList(new Student(1,"Krzysiek", "KL"));
    }

    @ApiOperation(value = "Find student by id", notes = "Provide information about student")
    @GetMapping("/{id}")
    public Student getStudents(@ApiParam(value = "unique id of student", example = "123") @PathVariable int id){
        return studentList
                .stream().filter(student -> student.getId() == id).findFirst().get();
    }

    @GetMapping
    public List<Student> getStudentList(){
        return studentList;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
         studentList.add(student);
    }
}
