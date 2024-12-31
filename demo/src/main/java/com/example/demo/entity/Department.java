package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.atomic.AtomicLong;

@Document
public class Department {

    @Id
    private  long departmentid;
    private  String departmentName;
    private  String departmentAddress;
    private  String departmentCode;

    @Override
    public String toString() {
        return "Department{" +
                "departmentid=" + departmentid +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    public long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(long departmentid) {
        if(this.departmentid == 0)
         this.departmentid = generateUniqueLongId();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Department(String departmentName, long departmentid, String departmentAddress, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentid = departmentid;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department(){
        if(this.departmentid == 0) this.departmentid = generateUniqueLongId();
    }

    private static final AtomicLong idCounter = new AtomicLong(1);
    private static Long generateUniqueLongId() {
        return idCounter.getAndIncrement();
    }
}
