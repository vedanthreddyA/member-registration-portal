package com.registration.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dependents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int count;
	private Date dob;
	private String memberId;
	
	
	public Dependents() {
		super();
		
	}
	
	
	public Dependents(Integer id, String name, int count, Date dob, String memberId) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.dob = dob;
		this.memberId = memberId;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "Dependents [id=" + id + ", name=" + name + ", count=" + count + ", dob=" + dob + ", memberId="
				+ memberId + "]";
	}
	
	
}
