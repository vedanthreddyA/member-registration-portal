import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowdependentsComponent } from './showdependents.component';

describe('ShowdependentsComponent', () => {
  let component: ShowdependentsComponent;
  let fixture: ComponentFixture<ShowdependentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowdependentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowdependentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
