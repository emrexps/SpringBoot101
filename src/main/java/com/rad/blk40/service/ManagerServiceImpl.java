package com.rad.blk40.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.blk40.model.Manager;
import com.rad.blk40.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addNewManager(Manager manager) {

		try {
			managerRepository.save(manager);

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List <Manager> findManagerByName(String name) {

		try {
			return managerRepository.findByNameOrderByNameAsc(name);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return Collections.emptyList();
	}

	@Override
	public List <Manager> findManagerBySurname(String surName) {

		try {
			return managerRepository.findBySurnameAllIgnoreCase(surName);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return Collections.emptyList();
	}

	@Override
	public List <Manager> findManagerByAge(Integer age) {

		try {
			return managerRepository.findByAgeOrderByNameAsc(age);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return Collections.emptyList();
	}

	@Override
	public List<Manager> findAll() {
		return managerRepository.findAll();
	}

	@Override
	public List <Manager> findAgesBetween(Integer age1, Integer age2) {

		return managerRepository.findByAgeBetween(age1, age2);
	}

	@Override
	public List<Manager> namedQueryExample() {
		Query q = em.createNamedQuery("Manager.names");
		// q.setParameter(1, "Thorben");
		return q.getResultList();

	}

	@Override
	public List<Manager> namedQueryExampleFindByName(String name) {
		Query q = em.createNamedQuery("Manager.findByName");
		q.setParameter(1, name);
		return q.getResultList();
	}

	@Override
	public List<Manager> findBySurnameQuery(String surname) {
		return managerRepository.findSurnameWithQuery(surname);
	}

}
