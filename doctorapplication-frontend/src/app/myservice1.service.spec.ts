import { TestBed } from '@angular/core/testing';

import { Myservice1Service } from './myservice1.service';

describe('Myservice1Service', () => {
  let service1: Myservice1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service1 = TestBed.inject(Myservice1Service);
  });

  it('should be created', () => {
    expect(service1).toBeTruthy();
  });
});