import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Memberdependents } from 'src/app/modal/memberdependents';
import { DependentsService } from 'src/app/services/dependents.service';

@Component({
  selector: 'app-showdependents',
  templateUrl: './showdependents.component.html',
  styleUrls: ['./showdependents.component.css']
})
export class ShowdependentsComponent implements OnInit {

  memberId: string = "";
  dependentList: Memberdependents[] = [];
  savedependent: Memberdependents = new Memberdependents();
  

  constructor(private route: ActivatedRoute,private dependentService: DependentsService) { }

  ngOnInit(): void {
    this.memberId = this.route.snapshot.params['memberId'];
    this.getDependentsByMemberId();
  }

   getDependentsByMemberId() {
    this.dependentService.getDependentsByMemberId(this.memberId).subscribe(data => {
      console.log(data);
      this.dependentList = data;
    }, error => console.log(error));
  }
  editDependent(id: number) {
    this.dependentService.getDependentById(id).subscribe(data => {
      console.log(data);
      this.savedependent = data;
      console.log("savedDependet::"+ this.savedependent)
    }, error => console.log(error)
    )
  }
  deleteDependent(id: number) {

  }
  updateDependent(dependent: Memberdependents, id: number) {
    this.dependentService.updateDependents(dependent, id).subscribe(data => {
      console.log(data);
      alert("updated successfully ..!")
      this.getDependentsByMemberId();
    }, error => console.log(error));
  }
  getToday(): string {
    return new Date().toISOString().split('T')[0]
  }
}
