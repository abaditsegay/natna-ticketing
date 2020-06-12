import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { BookingService } from './../services/booking.service';
import { TicketItem } from './../models/ticket-model';
@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  
  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    // this.bookingService.$ticketInfo
    // .subscribe( (concertEvent) => {
    //   console.log(concertEvent);
    // })
  }

  eventTitle: string;
  ticketNumber: string;
  eventDate: string;
  eventCategory: string;

  setTicketItems(ticketItem: TicketItem) {
    this.eventTitle = ticketItem.eventTitle;
    this.eventCategory = ticketItem.category;
    this.eventDate = ticketItem.eventDate;
    this.ticketNumber = ticketItem.ticketNumber;
    console.log(ticketItem);
  }
}
