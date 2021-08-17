package com.rad.blk40.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rad.blk40.model.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {

}
