import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DependentsComponent } from './dependents.component';

describe('DependentsComponent', () => {
  let component: DependentsComponent;
  let fixture: ComponentFixture<DependentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DependentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DependentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
