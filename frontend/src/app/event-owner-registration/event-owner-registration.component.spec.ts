import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventOwnerRegistrationComponent } from './event-owner-registration.component';

describe('EventOwnerRegistrationComponent', () => {
  let component: EventOwnerRegistrationComponent;
  let fixture: ComponentFixture<EventOwnerRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventOwnerRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventOwnerRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
