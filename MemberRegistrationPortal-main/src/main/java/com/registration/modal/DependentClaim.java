package com.registration.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DependentClaim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String memberName;
	private Date dateOfAdmission;
	private Date dateOfDischarge;
	private String providerName;
	private Double totalBillAmount;
	private String memberId;
	private long claimNumber;
	
	public DependentClaim() {
		super();
		
	}


	public DependentClaim(Integer id, String memberName, Date dateOfAdmission, Date dateOfDischarge,
			String providerName, Double totalBillAmount, String memberId, long claimNumber) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.dateOfAdmission = dateOfAdmission;
		this.dateOfDischarge = dateOfDischarge;
		this.providerName = providerName;
		this.totalBillAmount = totalBillAmount;
		this.memberId = memberId;
		this.claimNumber = claimNumber;
	}


	public long getClaimNumber() {
		return claimNumber;
	}


	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Date getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
}
