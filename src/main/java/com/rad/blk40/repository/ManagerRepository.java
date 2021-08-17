package com.rad.blk40.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rad.blk40.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
	
	List <Manager> findByNameOrderByNameAsc(String name);
	List <Manager> findBySurnameAllIgnoreCase(String surname);
	List <Manager> findByAgeOrderByNameAsc(Integer age);
	List <Manager> findByAgeBetween(Integer startAge, Integer endAge);
	
	@Query("Select p from Manager p where p.surname = :surname")
	List<Manager> findSurnameWithQuery(@Param("surname") String surname);


}
