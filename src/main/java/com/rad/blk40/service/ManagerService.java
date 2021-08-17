package com.rad.blk40.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rad.blk40.model.Manager;


public interface ManagerService {
	
	public boolean addNewManager(Manager manager);
	
	public List <Manager> findManagerByName(String name);
	
	public List <Manager> findManagerBySurname(String surName);
	
	public List <Manager>findManagerByAge(Integer age);
	
	public List <Manager> findAll();
	
	public List <Manager> findAgesBetween(Integer age1,Integer age2);
	
	public List <Manager> namedQueryExample();
	
	public List <Manager> namedQueryExampleFindByName(String name);
	
	public List <Manager> findBySurnameQuery(String surname);
	

}
