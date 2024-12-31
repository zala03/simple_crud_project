package com.example.demo.service;

import com.example.demo.entity.Department;
import java.util.*;


public interface Departmentserv {
    public Department savedep(Department department);

    //public String getDepbyId(Long depId);

    public List<Department> getallDepbyId();

    public void deletDepbyID(Long depId);

    public void updateDepbyID(Long depId , Department dp);
}
