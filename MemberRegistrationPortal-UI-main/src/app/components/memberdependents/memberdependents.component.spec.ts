import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberdependentsComponent } from './memberdependents.component';

describe('MemberdependentsComponent', () => {
  let component: MemberdependentsComponent;
  let fixture: ComponentFixture<MemberdependentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberdependentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberdependentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
