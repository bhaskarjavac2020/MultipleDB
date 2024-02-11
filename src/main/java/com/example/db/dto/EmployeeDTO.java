package com.example.db.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer id;
    private String employeeName;
    private Double salary;
}
