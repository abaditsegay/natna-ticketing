import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociateApprovalComponent } from './associate-approval.component';

describe('AssociateApprovalComponent', () => {
  let component: AssociateApprovalComponent;
  let fixture: ComponentFixture<AssociateApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssociateApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociateApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
