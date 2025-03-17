package com.example.SMS.services;

import com.example.SMS.dto.StudentDto;
import com.example.SMS.entity.StudentEntity;
import com.example.SMS.repository.StudentRepo;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    private StudentRepo studentRepo;

    //Create Student entry
    public StudentEntity createStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        //studentEntity.setStudId(0);
        studentEntity.setStudFirstName(studentDto.getStudFirstName());
        studentEntity.setStudLastName(studentDto.getStudLastName());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setGender(studentDto.getGender());
        studentRepo.save(studentEntity);
        return studentEntity;

    }

    //get all student details list
    public List<StudentEntity> getAllStudentRecord() {
        return studentRepo.findAll();
    }

    //delete student entry
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


    //Update Student data
    public StudentEntity updateStudent(Long id, StudentDto studentDto) {

        StudentEntity existingdata = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("student not found"));

        existingdata.setStudFirstName(studentDto.getStudFirstName());
        existingdata.setStudLastName(studentDto.getStudLastName());
        existingdata.setEmail(studentDto.getEmail());
        existingdata.setGender(studentDto.getGender());
        return studentRepo.save(existingdata);


    }

    //Get SingleRecord of student from database
    public Optional<StudentEntity> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public StudentEntity updateStudentPartially(Long id, StudentDto studentDto) {
        StudentEntity existingdata = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("student not found"));


//        existingdata.setStudFirstName(studentDto.getStudFirstName());
//        existingdata.setStudLastName(studentDto.getStudLastName());
         existingdata.setEmail(studentDto.getEmail());
        existingdata.setGender(studentDto.getGender());

        return studentRepo.save(existingdata);
    }


}