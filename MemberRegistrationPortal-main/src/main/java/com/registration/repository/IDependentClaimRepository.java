package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.modal.DependentClaim;

public interface IDependentClaimRepository extends JpaRepository<DependentClaim, Integer>{

}
