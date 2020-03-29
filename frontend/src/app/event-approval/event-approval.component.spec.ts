import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventApprovalComponent } from './event-approval.component';

describe('EventApprovalComponent', () => {
  let component: EventApprovalComponent;
  let fixture: ComponentFixture<EventApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
