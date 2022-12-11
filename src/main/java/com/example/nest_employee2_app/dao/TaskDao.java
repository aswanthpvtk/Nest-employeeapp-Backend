package com.example.nest_employee2_app.dao;

import com.example.nest_employee2_app.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Task,Integer> {


    @Query(value = "SELECT u.`address`,u.`email`, u.`name`, u.`phone`,c.complaint FROM `user` u JOIN cmp c ON c.user_id=u.id",nativeQuery = true)
    List<Map<String,String>> complaints();
}
