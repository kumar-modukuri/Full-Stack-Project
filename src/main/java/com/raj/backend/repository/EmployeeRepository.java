package com.raj.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.raj.backend.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,Integer>
{
	
}