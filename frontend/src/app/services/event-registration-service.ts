import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { ResponseStatus } from '../models/response-status';
import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { EventItem } from '../models/event-model';

const baseUrl: string = environment.baseUrl;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root',
})
export class EventRegistrationService {
  constructor(private httpClient: HttpClient) { }

    public createEvent(eventItem: EventItem) {
      let resp = this.httpClient.post<ResponseStatus>(baseUrl + '/event', 
        JSON.stringify(eventItem), httpOptions);

        return resp.pipe(
          map((response: ResponseStatus) => {
            return response;
          }), catchError(this.handleError)
        );
    }

    private handleError(error: HttpErrorResponse) {
      return throwError('Unknown error occured, please try again');
    }
}
