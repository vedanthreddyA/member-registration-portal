package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.modal.Claim;

public interface IClaimRepository extends JpaRepository<Claim, Integer>{

}
