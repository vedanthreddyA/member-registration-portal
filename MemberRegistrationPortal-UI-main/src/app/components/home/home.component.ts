import { Component, OnInit } from '@angular/core';
import { Member } from 'src/app/modal/member';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  member : Member = new Member();
  
  constructor() { }

  ngOnInit(): void {
  }

}
