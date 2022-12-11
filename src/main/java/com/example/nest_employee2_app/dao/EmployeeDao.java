package com.example.nest_employee2_app.dao;

import com.example.nest_employee2_app.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
