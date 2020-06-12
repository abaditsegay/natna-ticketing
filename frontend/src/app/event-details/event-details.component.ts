import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {

  constructor() { }
  eventLocation: string;
  eventname: string;
  eventDate: string;
  associatesList: string[];
  phoneNumber: string;
  email: string;
  ngOnInit() {
    this.eventname = "Mekelle 70 Enderta vs Welwalo Adigrat University";
    this.eventLocation = "Mekelle Tigray Stadium";
    this.eventDate = "May 25, 2020 03:30 AM";
    this.associatesList= ['ABC Internet Center','My Cafe'];
    this.phoneNumber="";
    this.email="";
  }

  onAssociateChange(){
  this.phoneNumber="phone: +251-911-517474";
  this.email="Email: mkstudio@gmail.com";
  }
}
