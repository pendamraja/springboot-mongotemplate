package com.springboot.mongotemplate.controller;

import com.springboot.mongotemplate.model.Employee;
import com.springboot.mongotemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/")
    public Employee save(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @GetMapping("/")
    public List<Employee> find()
    {
        return employeeService.find();
    }
    @PutMapping("/")
    public Employee update(@RequestBody Employee employee)
    {
        return employeeService.update(employee);
    }

    @DeleteMapping("/")
    public long delete(@RequestBody Employee employee)
    {
           return employeeService.delete(employee);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> findBySalary(@PathVariable int salary)
    {
        return employeeService.finBySalary(salary);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Employee> findByFirstname(@PathVariable String firstName)
    {
        return employeeService.finByFirstname(firstName);
    }
}
