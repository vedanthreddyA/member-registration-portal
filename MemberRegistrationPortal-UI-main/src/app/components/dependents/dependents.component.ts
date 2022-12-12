import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/modal/customer';
import { Existingmember } from 'src/app/modal/existingmember';
import { Member } from 'src/app/modal/member';
import { MemberRegistrationService } from 'src/app/services/member-registration.service';

@Component({
  selector: 'app-dependents',
  templateUrl: './dependents.component.html',
  styleUrls: ['./dependents.component.css']
})
export class DependentsComponent implements OnInit {

  memberList: Array<any> = [];
  member: Existingmember = new Existingmember();
  constructor(private memberService: MemberRegistrationService, private router: Router) { }

  ngOnInit(): void {
    this.getMemberAllMember();
  }
  deleteMember(id: number) {

  }
  editMember(id: number) {
    this.memberService.getMemberById(id).subscribe(data => {
      console.log(data);
      this.member = data;
    }, error => console.log(error)
    )
  }

  updateMember(member: Member, id: number) {
    this.memberService.updateMember(member, id).subscribe(data => {
      console.log(data);
      this.getMemberAllMember();
      alert("Student daetails updated successfully");
    })
  }

  getMemberAllMember() {
    this.memberService.getAllMember().subscribe(data => {
      console.log(data);
      this.memberList = data;
    }, error => console.log(error));
  }
  addDependent(response : string){
    this.router.navigate(['dependents', response]);
  }
  showDependent(response : string){
    this.router.navigate(['showdependents', response]);
  }
}


