import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { EventRegistrationService } from '../services/event-registration-service';
import { CreateStatus } from '../models/create-status';
import { EventItem } from '../models/event-model';


@Component({
  selector: 'event-registration',
  templateUrl: './event-registration.component.html',
  styleUrls: ['./event-registration.component.css']
})
export class EventRegistrationComponent implements OnInit {
  
  eventRegistrationForm: FormGroup;
  eventData: EventItem;
  createStatus: CreateStatus;
  created: string = "";
  createdMessage: string = "";

  constructor(
    private location: Location, 
    private formBuilder: FormBuilder,
    private eventRegistrationService: EventRegistrationService,
    private activatedRoute: ActivatedRoute
    ){}

    ngOnInit(){
      this.eventRegistrationForm = this.formBuilder.group({
        eventName: this.formBuilder.control(''),
        eventDescription: this.formBuilder.control(''),
        eventType: this.formBuilder.control(''),
        eventDate: this.formBuilder.control(''),
        eventStartTime: this.formBuilder.control(''),
        eventEndTime: this.formBuilder.control(''),
        selectedEventRegion: this.formBuilder.control(''),
        eventCity: this.formBuilder.control(''),
        eventAddress: this.formBuilder.control(''),
        eventImagePath: this.formBuilder.control(''),
        eventRegisterPhoneNumber: this.formBuilder.control(''),
        eventTicketSellStartDate: this.formBuilder.control('')
      });
    }

    /*changeEventType(e) {
      console.log(e.target.value);
    }

    changeRegion(e) {
      console.log(e.target.value);
    }*/

    createEvent(eventItem: any) {
      console.log(eventItem);
      this.eventData = {
        "event_name": eventItem.eventName,
        "event_description": eventItem.eventDescription,
        "event_type": eventItem.eventType,
        "event_date": eventItem.eventDate,
        "start_time": eventItem.eventStartTime,
        "end_time": eventItem.eventEndTime,
        "region": eventItem.selectedEventRegion,
        "city": eventItem.eventCity,
        "address": eventItem.eventAddress,
        "image_path": eventItem.eventImagePath,
        "ticket_open_date": eventItem.eventTicketSellStartDate
      };

      try {
        this.eventRegistrationService.createEvent(this.eventData)
          .subscribe(status => { 
            console.log("Original: " + JSON.stringify(this.eventData));
            this.createStatus = status;
            if( typeof(status) === typeof(this.createStatus)) {
              if (this.createStatus.responseCode === '00') {
                this.created = "success";
                this.createdMessage = "Successfully registered, please login";
              } else {
                this.created = "failure";
                this.createdMessage = "Unsuccessful, please try again!";
              }
            } else {
                this.created = "failure";
                this.createdMessage = "Unsuccessful, please try again!";
            }
          }, (errors: any) => {
              this.created = "failure";
              this.createdMessage = errors;
          });
        } catch(error) {
            this.created = "failure";
            this.createdMessage = "Unknow error ocurred, please try again!";
        }
    
          this.location.replaceState('');    
        //window.location.reload();
      }
}
