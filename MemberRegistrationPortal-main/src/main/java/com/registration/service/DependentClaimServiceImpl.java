package com.registration.service;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.exception.MemberException;
import com.registration.modal.DependentClaim;
import com.registration.repository.IDependentClaimRepository;
import com.registration.utility.MemberUtility;



@Service
public class DependentClaimServiceImpl implements IDependentClaimService{

	@Autowired
	IDependentClaimRepository dependentRepository;
	
	@Autowired
	ClaimServiceImpl ClaimService;
	
	@Override
	public DependentClaim createClaimForDependents(DependentClaim claim) {
		Date admission = claim.getDateOfAdmission();
		Date discharge = claim.getDateOfDischarge();
		System.out.println("Date of admission :: "+admission);
		System.out.println("Date of discharge :: "+discharge);
		try {
			ClaimService.compareDate(admission, discharge);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(claim.getTotalBillAmount() == 0.0) {
			throw new MemberException("Please provide the Amount");
		}
		long claimNumber = MemberUtility.getClaimNumber();
		claim.setClaimNumber(claimNumber);
		DependentClaim dependentclaim = dependentRepository.save(claim);
		return dependentclaim;
	}

}
