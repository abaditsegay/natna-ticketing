import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventOwnerApprovalComponent } from './event-owner-approval.component';

describe('EventOwnerApprovalComponent', () => {
  let component: EventOwnerApprovalComponent;
  let fixture: ComponentFixture<EventOwnerApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventOwnerApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventOwnerApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
