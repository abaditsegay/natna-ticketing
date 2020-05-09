import { ProfileItem } from '../models/profile-model';
import { ProfileByNamesItem } from '../models/profile-model-names';
import { ProfileByEmailItem } from '../models/profile-model-email';
import { ProfileByPhoneItem } from '../models/profile-model-phone';
import { ProfileByLocationItem } from '../models/profile-model-location';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { ResponseStatus } from '../models/response-status';
import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

const baseUrl: string = environment.baseUrl;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient: HttpClient) { }

  public updateProfile(profileItem: ProfileItem) {
    let resp = this.httpClient.put<ResponseStatus>(baseUrl + '/profile',JSON.stringify(profileItem), httpOptions);

      return resp.pipe(
        map((response: ResponseStatus) => {
          return response;
        }), catchError(this.handleError)
      );
  }

  public updateFirstLastNames(profileByNamesItem: ProfileByNamesItem) {
    let resp = this.httpClient.put<ResponseStatus>(baseUrl + '/profile/myinfo',JSON.stringify(profileByNamesItem), httpOptions);

      return resp.pipe(
        map((response: ResponseStatus) => {
          return response;
        }), catchError(this.handleError)
      );
  }

  public updateProfileByEmail(profileByEmailItem: ProfileByEmailItem) {
   
    let resp = this.httpClient.put<ResponseStatus>(baseUrl + '/profile/email',JSON.stringify(profileByEmailItem), httpOptions);

      return resp.pipe(
        map((response: ResponseStatus) => {
          return response;
        }), catchError(this.handleError)
      );
  }

  public updateProfileByPhonenumber(profileByPhoneItem: ProfileByPhoneItem) {
   
    let resp = this.httpClient.put<ResponseStatus>(baseUrl + '/profile/phonenumber',JSON.stringify(profileByPhoneItem), httpOptions);

      return resp.pipe(
        map((response: ResponseStatus) => {
          return response;
        }), catchError(this.handleError)
      );
  }

  public updateProfileByLocation(profileByLocationItem: ProfileByLocationItem) {
    
    let resp = this.httpClient.put<ResponseStatus>(baseUrl + '/profile/address',JSON.stringify(profileByLocationItem), httpOptions);

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
