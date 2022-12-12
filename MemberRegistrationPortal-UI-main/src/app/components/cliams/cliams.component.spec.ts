import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CliamsComponent } from './cliams.component';

describe('CliamsComponent', () => {
  let component: CliamsComponent;
  let fixture: ComponentFixture<CliamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CliamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CliamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
