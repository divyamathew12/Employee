package com.example.employee.Controller;

import com.example.employee.Entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}





















































//    public ResponseEntity<List<Employee>> getAllEmployees(){
//        List<Employee> employees = employeeService.getAllEmployees();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") Long id){
//        Employee employee = employeeService.getEmployeeById(id).getBody();
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
//        Employee createdEmployee = employeeService.createEmployee(employee);
//        return new ResponseEntity<>(createdEmployee,HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public  ResponseEntity<Employee> updateEmployee(
//            @PathVariable("id") Long id,
//            @Valid @RequestBody Employee employee
//    ){
//        Employee updatedEmployee = employeeService.updateEmployee(id,employee);
//        return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
//        employeeService.deleteEmployee(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
//
//






