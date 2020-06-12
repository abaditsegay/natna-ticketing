import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventOwnerReviewComponent } from './event-owner-review.component';

describe('EventOwnerReviewComponent', () => {
  let component: EventOwnerReviewComponent;
  let fixture: ComponentFixture<EventOwnerReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventOwnerReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventOwnerReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
