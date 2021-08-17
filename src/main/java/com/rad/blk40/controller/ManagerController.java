package com.rad.blk40.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rad.blk40.model.Manager;
import com.rad.blk40.service.ManagerService;

@RestController
@RequestMapping("/api/manager")
@CrossOrigin(origins = "http://example.com", maxAge = 3600) 
														
public class ManagerController {

	Logger logger = LoggerFactory.getLogger(ManagerController.class);

	@Autowired
	ManagerService managerService;

	@PostMapping
	@CacheEvict(value = "managers", allEntries = true)
	public boolean addNewManager(@RequestBody Manager manager) {
		return managerService.addNewManager(manager);
	}

	@GetMapping
	@Cacheable(value = "managers")
	public List<Manager> findAll() {

		return managerService.findAll();
	}

	@GetMapping("/namedquery")
	public List<Manager> namedQuery() {

		logger.info("named query called");
		logger.debug("named query debug");
		return managerService.namedQueryExample();
	}

	@GetMapping("/namedqueryfindByName/{name}")
	public List<Manager> namedQueryParam(@PathVariable String name) {

	
		return managerService.namedQueryExampleFindByName(name);
	}

	@GetMapping("/findByName/{name}")
	public List <Manager> findManagerByName(@PathVariable String name) {
		return managerService.findManagerByName(name);
	}

	@GetMapping("/findBySurname/{surname}")
	@CrossOrigin(origins = "http://localhost:9000")
	public List <Manager> findManagerBySurname(@PathVariable String surname) {
		return managerService.findManagerBySurname(surname);
	}

	@GetMapping("/findByAge/{age}")
	public List <Manager> findManagerByAge(@PathVariable Integer age) {
		return managerService.findManagerByAge(age);
	}

	@GetMapping("/findAgeBeetwen/{age}/{age2}")
	public List <Manager> findAgeBeetwen(@PathVariable Integer age, @PathVariable Integer age2) {
		return managerService.findAgesBetween(age, age2);
	}

	@GetMapping("/findBySurnameQuery/{surname}")
	public List<Manager> findManagerBySurnameQuery(@PathVariable String surname) {
		return managerService.findBySurnameQuery(surname);
	}

	@GetMapping("/testexception")
	public String testException() {

		try {
			int i = 1 / 0;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Foo Not Found", e);
		}

		return "abc";
	}

}
