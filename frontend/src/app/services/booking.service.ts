
import { TicketComponent } from './../ticket/ticket.component';
import { BookingItem } from '../models/booking-model';
import { Injectable,EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { ResponseStatus } from '../models/response-status';
import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { TicketItem } from '../models/ticket-model'



const baseUrl: string = environment.baseUrl;

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BookingService {
responseStatus: ResponseStatus;
$ticketInfo = new EventEmitter();
ticketItem: TicketItem;
  constructor(private httpClient: HttpClient) { 
    
  }

 
  public bookTicket(bookingItem: BookingItem) {
    let resp = this.httpClient.put<ResponseStatus>(baseUrl + '/profile',JSON.stringify(bookingItem), httpOptions);
    
    this.ticketItem.category='VIP';
    this.ticketItem.ticketNumber='123456789';
    this.ticketItem.eventDate='05/20/2020';
    this.ticketItem.eventTitle='Soccer game between Mekelle and Adigrat';
    this.$ticketInfo.emit(this.ticketItem);

    return resp.pipe(
      map((response: ResponseStatus) => {
        return response;
      }), catchError(this.handleError)
    );
    
}
  private handleError(error: HttpErrorResponse) {
    console.log(error.message);
    return throwError("Data error, please try again");
  }
}
