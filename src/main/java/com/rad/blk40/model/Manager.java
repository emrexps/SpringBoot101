package com.rad.blk40.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NamedQueries({
    @NamedQuery(name="Manager.names",query = "select  e.name from Manager e "),
    @NamedQuery(name="Manager.findByName",query = " from Manager e where name = ?1 ")
})
@SQLDelete(sql = "update Manager set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class Manager extends BaseEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String surname;
	private Integer age;
	private String gender;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private List<Employee> employees = new ArrayList<Employee>();
	
	@Column
	private boolean isDeleted;
	
	@PreRemove
	private void preRemove(){
	
		this.isDeleted = true;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public void addEmployees(Employee e) {
		this.employees.add(e);
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender
				+ ", employees=" + employees + ", isDeleted=" + isDeleted + "]";
	}
	

}
