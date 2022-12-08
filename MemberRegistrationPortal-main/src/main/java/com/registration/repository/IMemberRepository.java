package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.registration.modal.Member;

public interface IMemberRepository extends JpaRepository<Member, Integer>{

	@Modifying
	@Transactional
	@Query(value = "UPDATE member_registration.member m set m.member_id = :memberId where m.id = :id", nativeQuery = true)
	Integer updateMemberId(String memberId, Integer id);
	
	Optional<Member> findByMemberId(String memberId);
}
