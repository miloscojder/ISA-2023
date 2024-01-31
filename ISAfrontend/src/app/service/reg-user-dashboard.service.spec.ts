import { TestBed } from '@angular/core/testing';

import { RegUserDashboardService } from './reg-user-dashboard.service';

describe('RegUserDashboardService', () => {
  let service: RegUserDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegUserDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
