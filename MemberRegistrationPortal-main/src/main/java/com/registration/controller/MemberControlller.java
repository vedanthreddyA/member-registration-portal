package com.registration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.modal.Customer;
import com.registration.modal.Dependents;
import com.registration.modal.Member;
import com.registration.modal.Response;
import com.registration.service.IMemberService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberControlller {

	@Autowired
	IMemberService memberService;

	@GetMapping("/hello")
	public String Hello() {
		return "Welcome to Member Registration portal";
	}

	@PostMapping("/save")
	public String saveMember(@RequestBody Member member) {
		return memberService.saveMember(member);
	}

	@GetMapping("/getmember/{id}")
	public Optional<Member> getMember(@PathVariable String id) {
		return memberService.getMemberByMemberId(id);
	}

	@GetMapping("/getAllMembers")
	public List<Member> getAllMembers() {
		return memberService.getAllMember();

	}

	@GetMapping("/findmember/{id}")
	public Optional<Member> getMemberById(@PathVariable Integer id) {
		return memberService.getMemberById(id);
	}

	@PutMapping("/updatemember/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") Integer id, @RequestBody Member member) {
		return new ResponseEntity<Member>(memberService.updateMember(member, id), HttpStatus.OK);
	}

	@GetMapping("/getcustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable String id) {
		return memberService.getCustomerByMemberId(id);
	}

	@GetMapping("findcustomer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Integer id) {
		return memberService.getCustomerById(id);
	}

	@GetMapping("/getAllcustomers")
	public List<Customer> getAllCustomers() {
		return memberService.getAllCustomer();
	}

	@PostMapping("/savecustomer")
	public ResponseEntity<Response> saveCustomer(@RequestBody Customer customer) {
		return memberService.saveCustomer(customer);
	}

	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(memberService.updateCustomer(customer, id), HttpStatus.OK);
	}

	@PostMapping("/savedependent")
	public ResponseEntity<Response> saveDependents(@RequestBody Dependents dependents) {
		return memberService.saveDepents(dependents);
	}

	@GetMapping("/getdependents/{id}")
	public List<Dependents> getDependents(@PathVariable String id) {
		return memberService.getDependentsByMemberId(id);
	}

	@GetMapping("/findependents/{id}")
	public Optional<Dependents> getDependentsById(@PathVariable Integer id) {
		return memberService.getDependentsById(id);
	}

	@GetMapping("/getalldependents")
	public List<Dependents> getAllDependents() {
		return memberService.getAllDependents();
	}

	@PutMapping("/updatedependets/{id}")
	public ResponseEntity<Dependents> updateDependents(@PathVariable("id") Integer id,
			@RequestBody Dependents dependents) {
		return new ResponseEntity<Dependents>(memberService.updateDependents(dependents, id), HttpStatus.OK);
	}
}