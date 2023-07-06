package com.example.employee.service;

import com.example.employee.Entity.Department;
import com.example.employee.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartment = departmentRepository.findById(id);
        if (existingDepartment.isPresent()) {
            Department department = existingDepartment.get();
            department.setName(updatedDepartment.getName());
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}













































//    public Optional<Department> getDepartmentById(@PathVariable Long id){
//        Optional<Department> optionalDepartment = departmentRepository.findById(id);
//        return optionalDepartment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//    public Department createDepartment(Department department) {
//        return departmentRepository.save(department);
//    }
//    public void deleteDepartment(Long id) {
//        departmentRepository.deleteById(id);
//    }
//
//    public Department updateDepartment(Long id, Department department) {
//        Department existingDepartment = getDepartmentById(id).getBody();
//        existingDepartment.setId(department.getId());
//        existingDepartment.setName(department.getName());
//
//        return departmentRepository.save(department);
//    }
