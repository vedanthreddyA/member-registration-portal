import { Component, OnInit } from '@angular/core';
import { Memberdependents } from 'src/app/modal/memberdependents';
import { DependentsService } from 'src/app/services/dependents.service';

@Component({
  selector: 'app-updatedependents',
  templateUrl: './updatedependents.component.html',
  styleUrls: ['./updatedependents.component.css']
})
export class UpdatedependentsComponent implements OnInit {

  dependentList: Memberdependents[] = [];
  savedependent: Memberdependents = new Memberdependents();

  constructor(private dependentService: DependentsService) { }

  ngOnInit(): void {
    this.getDependentsByMemberId();
  }
  getDependentsByMemberId() {
    this.dependentService.getAllDependents().subscribe(data => {
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
}
