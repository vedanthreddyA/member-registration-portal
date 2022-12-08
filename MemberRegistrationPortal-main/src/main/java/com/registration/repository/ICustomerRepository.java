package com.registration.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.registration.modal.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	
	Optional<Customer> findByMemberId(String memberId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE member_registration.customer m set m.member_id = :memberId where m.id = :id", nativeQuery = true)
	void updateMemberId(String memberId, int id);

}
