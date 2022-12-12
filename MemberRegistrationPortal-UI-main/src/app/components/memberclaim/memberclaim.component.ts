import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Claim } from 'src/app/modal/claim';
import { Existingmember } from 'src/app/modal/existingmember';
import { Memberdependents } from 'src/app/modal/memberdependents';
import { ClaimService } from 'src/app/services/claim.service';
import { DependentsService } from 'src/app/services/dependents.service';

@Component({
  selector: 'app-memberclaim',
  templateUrl: './memberclaim.component.html',
  styleUrls: ['./memberclaim.component.css']
})
export class MemberclaimComponent implements OnInit {

  memberId : string ='';
  dependentList: Memberdependents[] = [];
  savedmember: Existingmember = new Existingmember();
  claim: Claim = new Claim();
  isDisabled: boolean = true;

  constructor(private dependentService: DependentsService, private claimService: ClaimService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.memberId = this.route.snapshot.params['memberId'];
    console.log("memberId ", this.memberId);
    this.getDependentsByMemberId();
  }
  getDependentsByMemberId() {
    this.dependentService.getDependentsByMemberId(this.memberId).subscribe(data => {
      console.log(data);
      this.dependentList = data;
    }, error => console.log(error));
  }
  createClaim(claim: Claim) {
    console.log('claim data ', claim);
    this.claimService.createClaimForDependent(claim).subscribe(data => {
      console.log(data);
      alert("Claim applied successfully..!")
      this.router.navigate(['claim']);
    }, error => console.log(error))
  }
  applyforClaim(id: number) {
    this.dependentService.getDependentById(id).subscribe(data => {
      console.log(data);
      this.savedmember = data;
      this.claim.dob = this.savedmember.dob;
      this.claim.memberId = this.savedmember.memberId;
      this.claim.memberName = this.savedmember.name;
      console.log("Date of Birth", this.claim.dob);
    }, error => console.log(error));
  }
}
