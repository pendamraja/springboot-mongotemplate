package com.springboot.mongotemplate.repository;


import com.springboot.mongotemplate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Employee save(Employee emp) {
        return mongoTemplate.save(emp);
    }

    public List<Employee> find() {
        return mongoTemplate.findAll(Employee.class);
    }

    public long delete(Employee employee) {
        return mongoTemplate.remove(employee).getDeletedCount();
    }

    public List<Employee> findBySalary(int salary) {
        Query query = new Query(Criteria.where("salary").gte(salary));
        return mongoTemplate.find(query, Employee.class);
    }

    public List<Employee> findByFirstname(String firstName) {
        Query query = new Query(Criteria.where("firstName").regex("^"+firstName));
        return mongoTemplate.find(query, Employee.class);
    }
}
