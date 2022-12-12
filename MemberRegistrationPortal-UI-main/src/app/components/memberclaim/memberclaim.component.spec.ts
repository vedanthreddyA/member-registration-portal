import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberclaimComponent } from './memberclaim.component';

describe('MemberclaimComponent', () => {
  let component: MemberclaimComponent;
  let fixture: ComponentFixture<MemberclaimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberclaimComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberclaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
