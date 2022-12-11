package com.example.nest_employee2_app.dao;

import com.example.nest_employee2_app.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `empid`, `mob`, `name`, `psw`, `salary`, `uname` FROM `employees` WHERE `email`=:email AND `psw`=:psw",nativeQuery = true)
    List<Employee> login(@Param("email") String email, @Param("psw")String psw);
}
