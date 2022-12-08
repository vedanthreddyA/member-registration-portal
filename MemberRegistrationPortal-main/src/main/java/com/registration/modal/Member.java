package com.registration.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String emailAddress;
	private String panNumber;
	private String contactNumber;
	private Date dob;
	private String address;
	private String country;
	private String state;
	private String memberId;

	public List<MemberDependents> getMemberDependents() {
		return memberDependents;
	}

	@OneToMany(targetEntity = MemberDependents.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "memberid_fk", referencedColumnName = "id")
	private List<MemberDependents> memberDependents;

	public Member() {
		super();
	}


	public Member(Integer id, String name, String emailAddress, String panNumber, String contactNumber, Date dob,
			String address, String country, String state, String memberId, List<MemberDependents> memberDependents) {
		super();
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.dob = dob;
		this.address = address;
		this.country = country;
		this.state = state;
		this.memberId = memberId;
		this.memberDependents = memberDependents;
	}


	public void setMemberDependents(List<MemberDependents> memberDependents) {
		this.memberDependents = memberDependents;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
