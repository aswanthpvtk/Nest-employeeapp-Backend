package com.example.nest_employee2_app.Controller;

import com.example.nest_employee2_app.dao.EmployeeDao;
import com.example.nest_employee2_app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class NestController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empreg",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> Empreg(@RequestBody Employee e){

        dao.save(e);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", produces = "application/json", consumes = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody Employee u)
    {
        System.out.println(u.getEmail());
        System.out.println(u.getPsw());
        List<Employee> result = (List<Employee>) dao.login(u.getEmail(), u.getPsw());
        HashMap<String, String> st = new HashMap<>();
        if (result.size() == 0)
        {
            st.put("status", "failed");
            st.put("message", "user doesn't exist");
        } else
        {
            int id = result.get(0).getId();
            st.put("userId", String.valueOf(id));
            st.put("status", "success");
            st.put("message", "success");
        }

        return st;
    }

}
