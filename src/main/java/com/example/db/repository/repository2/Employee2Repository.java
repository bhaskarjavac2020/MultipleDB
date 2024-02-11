package com.example.db.repository.repository2;

import com.example.db.entity.entitytwo.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employee2Repository")
public interface Employee2Repository extends JpaRepository<Employees,Integer> {
}
