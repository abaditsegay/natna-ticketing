
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

import { BookingService } from './../services/booking.service';
import { BookingItem } from './../models/booking-model';
import { TicketItem } from './../models/ticket-model';
import { ResponseStatus } from '../models/response-status';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit  {
  form: FormGroup;
  bookingData: BookingItem;
  ticketItem: TicketItem;
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private bookingService: BookingService,
    private activatedRoute: ActivatedRoute
    ){}
  ngOnInit(){
    this.form = this.formBuilder.group({
      bookingfirstName: this.formBuilder.control(''),
      bookingLastName: this.formBuilder.control(''),
      bookingEmail: this.formBuilder.control(''),
      numberoftickets: this.formBuilder.control(''),
      ticketCategory: this.formBuilder.control('')
    });
  }

  updateStatus: ResponseStatus;
  registered: string = "";
  signupMessage = "";

  bookTicket(book) {
    this.bookingData = {
      "firstName": book.bookingfirstName,
      "lastName": book.bookingLastName,
      "email": book.bookingEmail,
      "numberoftickets": book.numberoftickets,
      "ticketCategory": book.ticketCategory
    };

    this.bookingService.bookTicket(this.bookingData)
      .subscribe(data => { 
        this.updateStatus = data;
        if( typeof(data) === typeof(this.updateStatus)) {
          if (this.updateStatus.responseCode === '00') {
            this.registered = "success";
            this.signupMessage = "Successfully registered, please login";
          } else {
            this.registered = "failure";
            this.signupMessage = "Unsuccessful, please try again!";
          }
        } else {
            this.registered = "failure";
            this.signupMessage = "Unsuccessful, please try again!";
        }
        
      });
      this.location.replaceState('/ticket');  
      window.location.reload();
  }

}
