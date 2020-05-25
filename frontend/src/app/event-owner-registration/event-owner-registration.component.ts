import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'event-owner-registration',
  templateUrl: './event-owner-registration.component.html',
  styleUrls: ['./event-owner-registration.component.css']
})
export class EventOwnerRegistrationComponent implements OnInit {

  eventOwnerOnboardingForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.eventOwnerOnboardingForm = this.formBuilder.group({
      eventOwnerFirstName: this.formBuilder.control(''),
      eventOwnerLastName: this.formBuilder.control(''),
      eventOwnerAddress: this.formBuilder.control('')
    });
  }

  onboardingEventOwner(eventOwnerItem) {
    return null;
  }

}
