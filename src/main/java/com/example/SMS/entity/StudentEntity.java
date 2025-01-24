package com.example.SMS.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "Student")
public class StudentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long studId;
    //@JsonProperty("studId")
    private String studFirstName;
    private String studLastName;
    private String email;
    private String gender;
    private String address;
    private String dOB;
    private String joining_Date;
    private Integer mobile_no;

    public String getStudFirstName() {
        return studFirstName;
    }

    public void setStudFirstName(String studFirstName) {
        this.studFirstName = studFirstName;
    }

    public String getStudLastName() {
        return studLastName;
    }

    public void setStudLastName(String studLastName) {
        this.studLastName = studLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getJoining_Date() {
        return joining_Date;
    }

    public void setJoining_Date(String joining_Date) {
        this.joining_Date = joining_Date;
    }

    public Integer getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Integer mobile_no) {
        this.mobile_no = mobile_no;
    }
}
