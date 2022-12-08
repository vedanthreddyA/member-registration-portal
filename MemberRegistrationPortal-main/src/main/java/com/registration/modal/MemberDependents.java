package com.registration.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "member_dependents")
public class MemberDependents implements Serializable {

	 @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int count;
	private Date dob;
	private String memberId;

	public MemberDependents() {
		super();

	}


	public MemberDependents(Integer id, String name, int count, Date dob, String memberId) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.dob = dob;
		this.memberId = memberId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
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

}
