import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { SignUpStatus } from '../models/create-status';
import { SignUpItem } from '../models/signup-model';
import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

const baseUrl: string = environment.baseUrl;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root',
})
export class SignUpService {
  constructor(private httpClient: HttpClient) { }

    public signUp(signUpItem: SignUpItem) {
      let resp = this.httpClient.post<SignUpStatus>(baseUrl + '/user', 
        JSON.stringify(signUpItem), httpOptions);

        return resp.pipe(
          map((response: SignUpStatus) => {
            return response;
          }), catchError(this.handleError)
        );
    }

    private handleError(error: HttpErrorResponse) {
      console.log(error.message);
      return throwError("Data error, please try again");
    }
}
