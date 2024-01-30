import { TestBed } from '@angular/core/testing';

import { ScheduleTermService } from './schedule-term.service';

describe('ScheduleTermService', () => {
  let service: ScheduleTermService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduleTermService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
