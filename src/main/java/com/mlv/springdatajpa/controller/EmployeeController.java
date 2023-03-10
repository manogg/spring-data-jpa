package com.mlv.springdatajpa.controller;

import com.mlv.springdatajpa.entity.Employee;
import com.mlv.springdatajpa.response.EmployeeResponse;
import com.mlv.springdatajpa.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/create")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        return EmployeeResponse.responseBuilder("New Employee Added", HttpStatus.CREATED, employeeService.saveEmployee(employee));

    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllEmp() {

        return EmployeeResponse.responseBuilder("Employee List", HttpStatus.OK, employeeService.getAllEmployee());


    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {

        return EmployeeResponse.responseBuilder("Employee Updated", HttpStatus.OK, employeeService.updateEmployee(employee));
    }

    @GetMapping("/getById")
    public ResponseEntity<Object> getEmployeeById(@RequestParam(name = "id") Integer id) {

        return EmployeeResponse.responseBuilder("Employee Details given below", HttpStatus.OK, employeeService.getEmployeeById(id));

    }

    @GetMapping("/getByAge")
    public ResponseEntity<Object> getEmployeeByAge(@RequestParam(name = "empAge") Integer empAge) {

        return EmployeeResponse.responseBuilder("Employee By Age", HttpStatus.OK, employeeService.getEmployeeByAge(empAge));
    }

    @GetMapping("/getBySalary")
    public ResponseEntity<Object> getEmployeeBySalary(@RequestParam(name = "empSalary") Integer empSalary) {

        return EmployeeResponse.responseBuilder("Employee By Salary", HttpStatus.OK, employeeService.getEmployeeBySalary(empSalary));
    }

    @GetMapping("/count")
    public List<Integer> getEmployeesCount() {
        List<Integer> cnt=new ArrayList<>();
        cnt = employeeService.getEmployeesCount();
        return cnt;
    }
}
