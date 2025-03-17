package com.example.SMS.controller;

import com.example.SMS.dto.StudentDto;
import com.example.SMS.entity.StudentEntity;
import com.example.SMS.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class studentController
{
    @Autowired
    private StudentServices studentServices;

    @PostMapping("/studadd")
    public  ResponseEntity<StudentEntity> createStudent(@RequestBody StudentDto studentDto)
    {

        return ResponseEntity.ok(studentServices.createStudent(studentDto));
        //OR
        /*studentServices.createStudent(studentDto);
        return  "Student added";*/
    }

    @GetMapping("/getStudent")
    public ResponseEntity<List<StudentEntity>> getAllStudentRecord()
    {
        List<StudentEntity> list=studentServices.getAllStudentRecord();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        studentServices.deleteStudent(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto)
    {
        return ResponseEntity.ok(studentServices.updateStudent(id,studentDto));

    }

    @GetMapping(value = "/{id}")
    public Optional<StudentEntity> getStudentById(@PathVariable Long id)
    {
       return studentServices.getStudentById(id);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<StudentEntity> updateStudentPartially(@PathVariable Long id, @RequestBody StudentDto studentDto)
    {
        return ResponseEntity.ok(studentServices.updateStudentPartially(id,studentDto));

    }

}
