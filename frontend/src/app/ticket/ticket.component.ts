import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { BookingService } from './../services/booking.service';
@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  
  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.bookingService.$ticketInfo
    .subscribe( (concertEvent) => {
      console.log(concertEvent);
    })
  }
}
