import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatedependentsComponent } from './updatedependents.component';

describe('UpdatedependentsComponent', () => {
  let component: UpdatedependentsComponent;
  let fixture: ComponentFixture<UpdatedependentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatedependentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatedependentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
