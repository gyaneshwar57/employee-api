package com.gyaneshwar.employeeapi.service;

import com.gyaneshwar.employeeapi.model.Employee;
import com.gyaneshwar.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee emp) {
        return repository.save(emp);
    }

    public Employee updateEmployee(Long id, Employee updatedEmp) {
        Employee emp = repository.findById(id).orElse(null);
        if (emp != null) {
            emp.setName(updatedEmp.getName());
            emp.setRole(updatedEmp.getRole());
            emp.setEmail(updatedEmp.getEmail());
            return repository.save(emp);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
