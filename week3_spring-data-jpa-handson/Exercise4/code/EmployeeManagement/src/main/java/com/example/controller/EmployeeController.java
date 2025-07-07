package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee() {
    	System.out.println("abcd");
    	Employee emp=new Employee();
    	emp.setName("abhiram");
        employeeService.addEmployee(emp);
        return "Employee saved!";
    }
}
