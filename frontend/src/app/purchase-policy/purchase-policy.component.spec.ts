import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchasePolicyComponent } from './purchase-policy.component';

describe('PurchasePolicyComponent', () => {
  let component: PurchasePolicyComponent;
  let fixture: ComponentFixture<PurchasePolicyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchasePolicyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchasePolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
