package com.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.registration.modal.Dependents;

public interface IDependentRepository extends JpaRepository<Dependents, Integer>{

	@Query(value = "SELECT * FROM member_registration.dependents WHERE member_id = ?1", nativeQuery = true)
	List<Dependents> findAllDependents(String memberId);

}
