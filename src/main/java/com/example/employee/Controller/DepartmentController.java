package com.example.employee.Controller;

import com.example.employee.Entity.Department;
import com.example.employee.Entity.Employee;
import com.example.employee.Repository.DepartmentRepository;
import com.example.employee.service.DepartmentService;
import com.example.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
























































//    @GetMapping
//    public ResponseEntity<List<Department>> getAllDepartments(){
//        List<Department> departments = departmentService.getAllDepartments();
//        return new ResponseEntity<>(departments, HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Department>getDepartmentById(@PathVariable("id") Long id){
//        Department department = departmentService.getDepartmentById(id).getBody();
//        return new ResponseEntity<>(department, HttpStatus.OK);
//    }
//    @PostMapping
//    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department){
//        Department createdDepartment = departmentService.createDepartment(department);
//        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
//    }
//    @PutMapping("/{id}")
//    public  ResponseEntity<Department> updateDepartment(
//            @PathVariable("id") Long id,
//            @Valid @RequestBody Department department
//    ){
//        Department updatedDepartment = departmentService.updateDepartment(id,department);
//        return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
//        departmentService.deleteDepartment(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//}
