package com.example.db.controller;

import com.example.db.dto.EmployeeDTO;
import com.example.db.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/test")
    public String getName(){
        return "API is working";
    }
    @GetMapping("/get-all-emploees")
    public List<EmployeeDTO> getAllEployees(){
        return employeeService.getAllEmployees();
    }

}
