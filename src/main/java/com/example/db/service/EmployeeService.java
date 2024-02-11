package com.example.db.service;

import com.example.db.dto.EmployeeDTO;
import com.example.db.entity.entityone.Employees;
import com.example.db.repository.repository1.Employee1Repository;
import com.example.db.repository.repository2.Employee2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final Employee1Repository employee1Repository;
    @Autowired
    @Qualifier("employee2Repository")
    private Employee2Repository employee2Repository;

    public EmployeeService(Employee1Repository employee1Repository) {
        this.employee1Repository = employee1Repository;
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> allEmployees=new ArrayList<EmployeeDTO>();
        List<com.example.db.entity.entitytwo.Employees> employees2=employee2Repository.findAll();
        List<Employees> employees1 =employee1Repository.findAll();
        for(com.example.db.entity.entitytwo.Employees employees:employees2){
            EmployeeDTO employeeDTO=new EmployeeDTO();
            employeeDTO.setId(employees.getId());
            employeeDTO.setEmployeeName(employees.getEmployeeName());
            employeeDTO.setSalary(employees.getSalary());
            allEmployees.add(employeeDTO);
        }
        for(Employees employees : employees1){
            EmployeeDTO employeeDTO=new EmployeeDTO();
            employeeDTO.setId(employees.getId());
            employeeDTO.setEmployeeName(employees.getEmployeeName());
            employeeDTO.setSalary(employees.getSalary());
            allEmployees.add(employeeDTO);
        }
        return allEmployees;
    }
}
