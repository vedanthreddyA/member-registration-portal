package com.registration.service;

import com.registration.modal.DependentClaim;

public interface IDependentClaimService {

	DependentClaim createClaimForDependents(DependentClaim claim);
}
