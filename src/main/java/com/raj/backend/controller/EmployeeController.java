package com.raj.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.backend.model.Employee;
import com.raj.backend.repository.EmployeeRepository;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController 
{
	@Autowired
	EmployeeRepository repo;
	
	//CREACT
    
    @PostMapping
	public String addEmployee(@RequestBody Employee emp)
	{
    	try
		{
			if(repo.existsById(emp.getEid()))
    		{
    			return "EXISTED";
    		}
			repo.save(emp);
			return "ADDED";
		}
		catch(Exception e)
		{
			return "ERROR";
		}
	}

	//READ BY ID

	@GetMapping("{id}")
	public Employee getEmployee(@PathVariable Integer id) 
	{
        try 
		{
			return repo.findById(id).orElse(null);
		} 
		catch(Exception e) 
		{
			return null;
		}
	}
	
	
	//READ ALL
	
    @GetMapping
    public List<Employee> getEmployees() 
	{
        try 
		{
            return repo.findAll(Sort.by(Sort.Direction.ASC, "_id"));
        } 
		catch(Exception e) 
		{
            return Collections.emptyList();
        }
    }

	//UPDATE

	@PutMapping("{id}")
	public String updEmployee(@RequestBody Employee emp)
	{
		try
		{
			if(repo.existsById(emp.getEid()))
    		{
				repo.save(emp);
				return "UPDATED";
    		}
			return "NOT FOUND";
		}
		catch(Exception e)
		{
			return "ERROR";
		}
    }
    
	//DELETE
	
    @DeleteMapping("{id}")
	public String delEmployee(@PathVariable Integer id)
	{
    	try 
		{
			repo.deleteById(id);
			return "DELETED";
		} 
		catch(Exception e) 
		{
			return "ERROR";
		}
	}
}