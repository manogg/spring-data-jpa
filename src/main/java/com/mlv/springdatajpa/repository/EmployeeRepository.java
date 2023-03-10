package com.mlv.springdatajpa.repository;

import com.mlv.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByEmpAge(Integer empAge);

    @Query(value="select * from employee where emp_salary >=:empSalary",nativeQuery = true)
    List<Employee> findByEmpSalary(@Param("empSalary") Integer empSalary);

    @Query(value="select * from employee",countQuery = "select count(*) from employee",nativeQuery = true)
    List<Integer> employeesCount();
}
