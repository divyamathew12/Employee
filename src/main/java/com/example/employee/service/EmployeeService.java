package com.example.employee.service;


import com.example.employee.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.employee.Repository.EmployeeRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService (EmployeeRepository employeeRepository){
    this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Optional<Employee> getEmployeeById(Long id) {
            return employeeRepository.findById(id);
        }

        public Employee createEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }

        public Employee updateEmployee(Long id, Employee updatedEmployee) {
            Optional<Employee> existingEmployee = employeeRepository.findById(id);
            if (existingEmployee.isPresent()) {
                Employee employee = existingEmployee.get();
                employee.setName(updatedEmployee.getName());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setPhone(updatedEmployee.getPhone());
                employee.setDepartment(updatedEmployee.getDepartment());
                return employeeRepository.save(employee);
            }
            return null;
        }

        public void deleteEmployee(Long id) {
            employeeRepository.deleteById(id);
        }
    }

































































//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//    public Optional<Employee> getEmployeeById(@PathVariable Long id){
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        return optionalEmployee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    public Employee createEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//    public void deleteEmployee(Long id) {
//        employeeRepository.deleteById(id);
//    }
//
//    public Employee updateEmployee(Long id, Employee employee) {
//        Employee existingEmployee = getEmployeeById(id).getBody();
//        existingEmployee.setId(employee.getId());
//        existingEmployee.setName(employee.getName());
//        existingEmployee.setEmail(employee.getEmail());
//        existingEmployee.setPhone(employee.getPhone());
//       // existingEmployee.setDepartment_id(employee.getDepartment_id());
//
//        return employeeRepository.save(employee);
//    }
//
//
//}