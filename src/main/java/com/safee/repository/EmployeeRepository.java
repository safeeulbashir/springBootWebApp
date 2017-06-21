package com.safee.repository;

import org.springframework.data.repository.CrudRepository;

import com.safee.model.Employee;
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
