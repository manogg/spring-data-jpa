package com.mlv.springdatajpa.service;

import com.mlv.springdatajpa.entity.Employee;
import com.mlv.springdatajpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);

    }
    public List<Employee> getAllEmployee(){

        List<Employee> listOfEmployee=new ArrayList<Employee>();

        listOfEmployee= employeeRepository.findAll();

        return listOfEmployee;
    }

    public Employee updateEmployee(Employee employee){

       return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id){

       return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeeByAge(Integer empAge){

        return employeeRepository.findByEmpAge(empAge);
    }

    public List<Employee> getEmployeeBySalary(Integer empSalary){

        return employeeRepository.findByEmpSalary(empSalary);
    }

    public List<Integer> getEmployeesCount(){

        List<Integer> cnt=new ArrayList<>();
        cnt=employeeRepository.employeesCount();
        return cnt;

    }

}
