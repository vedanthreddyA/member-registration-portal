import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/modal/customer';
import { Member } from 'src/app/modal/member';
import { MemberRegistrationService } from 'src/app/services/member-registration.service';

@Component({
  selector: 'app-registrationform',
  templateUrl: './registrationform.component.html',
  styleUrls: ['./registrationform.component.css']
})
export class RegistrationformComponent implements OnInit {

  member: Member = new Member();
  memberForm!: FormGroup;
  submitted = false;
  response = "";
  countryName = "";
  city = "";
  Country: Country[] = [];
  City: City[] = [];
  registerSucess: boolean = false;
  lessThanEighteen: boolean = false;
  errorMessage = '';
  cpass: string = ''
  customer: Customer = {
    id: 0,
    name: '',
    emailAddress: '',
    contactNumber: '',
    address: '',
    dob: new Date(),
    password: '',
    panNumber: '',
    country: '',
    state: ''
  }

  constructor(private memberService: MemberRegistrationService,
    private formBuilder: FormBuilder,
    private router: Router,) { }

  ngOnInit(): void {
    this.memberForm = this.formBuilder.group({
      username: ['', Validators.required]
    });
    this.getCountry();
  }
  get f() { return this.memberForm.controls; }

  saveMember(member: Member) {
    this.submitted = true;
    if (this.memberForm.invalid) {
      return;
    }
    this.memberService.saveMember(member).subscribe(response => {
      alert("Successfully added Memebr in Record");
      console.log(response);
    }, error => {
      console.log(error);
    }
    )
  }
  saveCust(cust: Customer, pass: string) {
    console.log("country", this.countryName);
    this.customer.country = this.countryName;
    this.customer.state = this.city;
    console.log('customer data', cust);
    this.memberService.saveMember(cust).subscribe(response => {
      console.log(response);
      this.response = response.memberId;
      this.registerSucess = true;
    }, error => {
      console.log(error);
    }
    )
  }
  addDependent() {
    this.router.navigate(['dependents', this.response]);
  }
  dependentClose() {
    this.router.navigate(['updatemember']);
  }
  getCountry() {
    this.Country.push({ Id: 1, name: "Pakistan" }, { Id: 2, name: "India" }, { Id: 3, name: "Australia" });
    console.log("counrty");
    console.log(this.Country);
  }
  getCity(event: any) {
    this.City = [];
    this.countryName = event.target.value;
    if (this.countryName == 'India') {
      this.City.push({ cityId: 1, name: "Surat" }, { cityId: 2, name: "UP" }, { cityId: 3, name: "Ahemdabad" });
    } else if (this.countryName == 'Australia') {
      this.City.push({ cityId: 1, name: "Sydney" }, { cityId: 2, name: "Gold Cost" }, { cityId: 3, name: "Darwin" });
    } else if (this.countryName == 'Pakistan') {
      this.City.push({ cityId: 1, name: "Sindh" }, { cityId: 2, name: "Balochistan" }, { cityId: 3, name: "Gilgit-Baltistan" });
    }
  }

  getToday(): string {
    return new Date().toISOString().split('T')[0]
  }

}
interface Country {
  Id: number;
  name: string;
}
interface City {
  cityId: number;
  name: string;
}