package com.mlv.springdatajpa.controller;

import com.mlv.springdatajpa.entity.Employee;
import com.mlv.springdatajpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/create")
    public Employee addEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/get-all")
    public List<Employee> getAllEmp(){
        return employeeService.getAllEmployee();

    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/getById")
    public Optional<Employee> getEmployeeById(@RequestParam(name="id") Integer id){

       return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getByAge")
    public List<Employee> getEmployeeByAge(@RequestParam(name="empAge") Integer empAge){

        return employeeService.getEmployeeByAge(empAge);
    }

    @GetMapping("/getBySalary")
    public List<Employee> getEmployeeBySalary(@RequestParam(name="empSalary") Integer empSalary){

        return employeeService.getEmployeeBySalary(empSalary);
    }

    @GetMapping("/count")
    public Integer getEmployeesCount(){

        int cnt=0;
        cnt=employeeService.getEmployeesCount();
        return cnt;
    }

}
