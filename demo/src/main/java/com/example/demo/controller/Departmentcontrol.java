package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.Departmentserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class Departmentcontrol {

    @Autowired
    public Departmentserv deps;

    @PostMapping("/deps")
    public Department sveDev(@RequestBody Department dep){
             return deps.savedep(dep);
    }

//    @GetMapping("/deps/{id}")
//    public String findDep(@PathVariable("id") Long departmentId){
//             return deps.getDepbyId(departmentId);
//    }


    @GetMapping("/alldeps")
    public List<Department> findDepall(){
        return deps.getallDepbyId();
    }

    @DeleteMapping("/deleteDep/{id}")
    public void DeleteDepbyId(@PathVariable("id") Long depId){
        deps.deletDepbyID(depId);
    }

    @PutMapping("/updateDep/{id}")
    public void updateDepbyId(@PathVariable("id") Long depId , @RequestBody Department dep){
         deps.updateDepbyID(depId,dep);


    }


}
