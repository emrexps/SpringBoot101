package com.rad.blk40.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class Student  extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -2952735933715107252L;
	
	private String name;
	
	private String surname;
	
	private String gender;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", gender=" + gender + ", age=" + age + "]";
	}
	

	
}
