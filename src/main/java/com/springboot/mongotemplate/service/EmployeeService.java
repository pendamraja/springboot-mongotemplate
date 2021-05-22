package com.springboot.mongotemplate.service;

import com.springboot.mongotemplate.model.Employee;
import com.springboot.mongotemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee emp)
    {
        emp.setJoiningDate(new Date());
        return employeeRepository.save(emp);
    }

    public Employee update(Employee emp)
    {
       return employeeRepository.save(emp);
    }

    public List<Employee> find()
    {
        return employeeRepository.find();
    }

    public long delete(Employee employee) {
        return employeeRepository.delete(employee);
    }

    public List<Employee> finBySalary(int salary) {
        return employeeRepository.findBySalary(salary);
    }

    public List<Employee> finByFirstname(String firstName) {
        return employeeRepository.findByFirstname(firstName);
    }
}
