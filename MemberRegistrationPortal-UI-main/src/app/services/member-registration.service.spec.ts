import { TestBed } from '@angular/core/testing';

import { MemberRegistrationService } from './member-registration.service';

describe('MemberRegistrationService', () => {
  let service: MemberRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MemberRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
