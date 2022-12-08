package com.registration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.registration.exception.MemberException;
import com.registration.modal.Customer;
import com.registration.modal.Dependents;
import com.registration.modal.Member;
import com.registration.modal.MemberDependents;
import com.registration.modal.Response;
import com.registration.repository.ICustomerRepository;
import com.registration.repository.IDependentRepository;
import com.registration.repository.IMemberRepository;
import com.registration.utility.MemberUtility;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	IMemberRepository memberRepository;

	@Autowired
	IDependentRepository dependentRepository;

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public String saveMember(Member member) {
		Random random = new Random();
		Optional<Member> oldMember = null;
		Member saveMember = memberRepository.save(member);
		int id = saveMember.getId();
		// Generates random integers 0 to 999
		int registrationNumber = random.nextInt(999) + 100;
		String memberId = "R-" + registrationNumber;
		// First we need to get memberId if exit then generate new member id
		oldMember = getMemberByMemberId(memberId);
		System.out.println("OldMember :: " + oldMember.isPresent());
		if (oldMember.isPresent()) {
			String oldMemberId = oldMember.get().getMemberId();
			System.out.println("oldMember Id ::" + oldMemberId + "new Member Id ::" + memberId);
			if (oldMemberId.equalsIgnoreCase(memberId)) {
				registrationNumber = random.nextInt(999) + 100;
				memberId = "R-" + registrationNumber;
				memberRepository.updateMemberId(memberId, id);
			}
		} else {
			memberRepository.updateMemberId(memberId, id);
		}

		return memberId;
	}

	@Override
	public List<Member> getAllMember() {
		return memberRepository.findAll();
	}

	@Override
	public Optional<Member> getMemberByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public Optional<Member> getMemberById(Integer id) {
		return memberRepository.findById(id);
	}

	@Override
	public Member updateMember(Member member, Integer id) {
		List<MemberDependents> listDependents = new ArrayList<>();
		Member existingMember = memberRepository.findById(id)
				.orElseThrow(() -> new MemberException("Member", "id", id));
		existingMember.setName(member.getName());
		existingMember.setEmailAddress(member.getEmailAddress());
		existingMember.setPanNumber(member.getPanNumber());
		existingMember.setContactNumber(member.getPanNumber());
		existingMember.setDob(member.getDob());
		existingMember.setAddress(member.getAddress());
		existingMember.setCountry(member.getCountry());
		existingMember.setState(member.getState());
		existingMember.setMemberId(member.getMemberId());

		List<MemberDependents> memberDependents = member.getMemberDependents();
		for (MemberDependents memberDependent : memberDependents) {
			String name = memberDependent.getName();
			Date dob = memberDependent.getDob();
			int dependentsId = memberDependent.getId();
			MemberDependents dependents = new MemberDependents();
			dependents.setName(name);
			dependents.setDob(dob);
			dependents.setId(dependentsId);
			listDependents.add(dependents);
		}
		existingMember.setMemberDependents(listDependents);
		// int numberOfDependents = memberDependents.size();
		memberRepository.save(existingMember);
		return existingMember;
	}

	@Override
	public ResponseEntity<Response> saveDepents(Dependents dependents) {
		String memberId = dependents.getMemberId();
		Response response = new Response();
		int count = 0;
		MemberUtility.compareDate(dependents.getDob());
		List<Dependents> saveddependents = getDependentsByMemberId(memberId);
		if (null != saveddependents) {
			count = saveddependents.size();
			System.out.println("saved Dependents count ::" + count);
		}
		if (count >= 2) {
			System.out.println("Exception :::::::You can not add more than 2 dependents");
			throw new MemberException("You can not add more than 2 dependents");
		} else {
			count++;
			dependents.setCount(count);
		}
		System.out.println("Dependents saved successfully");
		Dependents savedependents = dependentRepository.save(dependents);
		memberId = savedependents.getMemberId();
		response.setMemberId(memberId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> saveCustomer(Customer customer) {
		Random random = new Random();
		Optional<Customer> oldMember = null;
		Date dob = customer.getDob();
		int age = MemberUtility.ageCalculation(dob);
		Response response = new Response();
		if (age <= 18) {
			throw new MemberException("Member age should be greater than 18");
		} else {
			Customer saveMember = customerRepository.save(customer);
			int id = saveMember.getId();
			int registrationNumber = MemberUtility.getMemberId();
			String memberId = "R-" + registrationNumber;
			// First we need to get memberId if exit then generate new member id
			oldMember = getCustomerByMemberId(memberId);
			System.out.println("OldMember :: " + oldMember.isPresent());
			if (oldMember.isPresent()) {
				String oldMemberId = oldMember.get().getMemberId();
				System.out.println("oldMember Id ::" + oldMemberId + "new Member Id ::" + memberId);
				if (oldMemberId.equalsIgnoreCase(memberId)) {
					registrationNumber =MemberUtility.getMemberId();
					memberId = "R-" + registrationNumber;
					customerRepository.updateMemberId(memberId, id);
				}
			} else {
				customerRepository.updateMemberId(memberId, id);
			}
			response.setMemberId(memberId);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}

	@Override
	public Optional<Customer> getCustomerByMemberId(String memberId) {
		return customerRepository.findByMemberId(memberId);
	}

	@Override
	public Optional<Customer> getCustomerById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer id) {
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new MemberException("Member", "id", id));
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmailAddress(customer.getEmailAddress());
		existingCustomer.setPanNumber(customer.getPanNumber());
		existingCustomer.setContactNumber(customer.getContactNumber());
		existingCustomer.setDob(customer.getDob());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setCountry(customer.getCountry());
		existingCustomer.setState(customer.getState());
		existingCustomer.setMemberId(customer.getMemberId());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public List<Dependents> getDependentsByMemberId(String memberId) {
		return dependentRepository.findAllDependents(memberId);
	}

	@Override
	public Optional<Dependents> getDependentsById(Integer id) {
		return dependentRepository.findById(id);
	}

	@Override
	public Dependents updateDependents(Dependents dependents, Integer id) {
		Dependents existingDependent = dependentRepository.findById(id)
				.orElseThrow(() -> new MemberException("Dependent", "id", id));
		existingDependent.setName(dependents.getName());
		existingDependent.setDob(dependents.getDob());
		existingDependent.setMemberId(dependents.getMemberId());
		existingDependent.setCount(dependents.getCount());
		dependentRepository.save(existingDependent);
		return existingDependent;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public List<Dependents> getAllDependents() {
		return dependentRepository.findAll();
	}

}
