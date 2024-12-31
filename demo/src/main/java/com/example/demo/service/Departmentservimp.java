package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.Departmentrepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Departmentservimp implements Departmentserv {

             @Autowired
             private Departmentrepo departmentrepo;

             @Override
             public Department savedep(Department department){
                 return  departmentrepo.save(department);
             }



            @Override
            public List<Department> getallDepbyId() {
                  return departmentrepo.findAll();
            }

            @Override
            public void deletDepbyID(Long depId) {
                    departmentrepo.deleteById(depId);
             }

             @Override
             public void updateDepbyID(Long depId, Department dep) {
                 Optional<Department> optionalDepartment = departmentrepo.findById(depId);

                 if (optionalDepartment.isPresent()) {
                     Department existingDepartment = optionalDepartment.get();


                     existingDepartment.setDepartmentName(dep.getDepartmentName());
                     existingDepartment.setDepartmentAddress(dep.getDepartmentAddress());
                     existingDepartment.setDepartmentCode(dep.getDepartmentCode());


                     departmentrepo.save(existingDepartment);
                 } else {

                     throw new EntityNotFoundException("Department with ID " + depId + " not found.");
                 }
             }
}
