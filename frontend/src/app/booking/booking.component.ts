
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
  @Output() public ticketItem: EventEmitter<TicketItem> = new EventEmitter();
  form: FormGroup;
  bookingData: BookingItem;
  
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private bookingService: BookingService,
    private activatedRoute: ActivatedRoute,
    private router: Router
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
 
  ticketItems(bookingItem: BookingItem){
    let ticketItems: TicketItem = {
      "ticketNumber": bookingItem.firstName,
      "category": bookingItem.ticketCategory,
      "eventTitle": bookingItem.firstName,
      "eventDate" : bookingItem.lastName
    };
    this.ticketItem.emit(ticketItems);
  }
  bookTicket(book) {
    this.bookingData = {
      "firstName": book.bookingfirstName,
      "lastName": book.bookingLastName,
      "email": book.bookingEmail,
      "numberoftickets": book.numberoftickets,
      "ticketCategory": book.ticketCategory
    };
    this.ticketItems(this.bookingData);
    this.router.navigateByUrl('/ticket');  
  }

 
}
