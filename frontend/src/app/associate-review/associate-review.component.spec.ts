import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociateReviewComponent } from './associate-review.component';

describe('AssociateReviewComponent', () => {
  let component: AssociateReviewComponent;
  let fixture: ComponentFixture<AssociateReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssociateReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociateReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
