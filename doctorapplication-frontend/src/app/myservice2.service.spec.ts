import { TestBed } from '@angular/core/testing';

import { Myservice2Service } from './myservice2.service';

describe('Myservice2Service', () => {
  let service2: Myservice2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service2 = TestBed.inject(Myservice2Service);
  });

  it('should be created', () => {
    expect(service2).toBeTruthy();
  });
});