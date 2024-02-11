package com.example.db.repository.repository1;

import com.example.db.entity.entityone.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employee1Repository")
public interface Employee1Repository extends JpaRepository<Employees,Integer> {
}
