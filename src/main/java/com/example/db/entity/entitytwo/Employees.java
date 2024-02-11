package com.example.db.entity.entitytwo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "employees")
@Data
@Entity
public class Employees {
    @Id
    @Column(name = "employee_id")
    private Integer id;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "salary")
    private Double salary;
}
