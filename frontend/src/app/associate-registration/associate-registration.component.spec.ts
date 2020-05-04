import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociateRegistrationComponent } from './associate-registration.component';

describe('AssociateRegistrationComponent', () => {
  let component: AssociateRegistrationComponent;
  let fixture: ComponentFixture<AssociateRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssociateRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociateRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
