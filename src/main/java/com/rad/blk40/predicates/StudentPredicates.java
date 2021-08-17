package com.rad.blk40.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.rad.blk40.model.Manager;
import com.rad.blk40.model.Student;

public class StudentPredicates {
	
	
	public static Predicate<Student> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	public static Predicate<Student> isAdultFemale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("F");
	}

	public static Predicate<Student> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}

	public static Predicate <Student> whatName(String name){
		return p->p.getName().equalsIgnoreCase(name);
	}
	
	public static List<Student> filterEmployees(List<Student> employees, Predicate<Student> predicate) 
	{
		return employees.stream().filter(predicate).collect(Collectors.<Student>toList());
	}
}
