import { TestBed } from '@angular/core/testing';

import { FiboService } from './fibo.service';

describe('FiboService', () => {
  let service: FiboService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FiboService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
