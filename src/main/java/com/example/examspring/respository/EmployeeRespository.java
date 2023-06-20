package com.example.examspring.respository;

import com.example.examspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository  extends JpaRepository<Employee, Long> {
}
