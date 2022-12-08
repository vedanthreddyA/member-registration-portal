package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.modal.Claim;
import com.registration.modal.DependentClaim;
import com.registration.service.IClaimService;
import com.registration.service.IDependentClaimService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberClaimController {

	@Autowired
	IClaimService claimService;
	
	@Autowired
	IDependentClaimService dependentClaimService;

	@PostMapping("/createClaim")
	public Claim createClaim(@RequestBody Claim claim) {
		return claimService.createClaim(claim);
	}
	
	@PostMapping("/dependentclaim")
	public DependentClaim createClaimForDependent(@RequestBody DependentClaim dependetnClaim) {
		return dependentClaimService.createClaimForDependents(dependetnClaim);
	}
}
