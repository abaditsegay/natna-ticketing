import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

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

    public signUp(signUpItem) {
      return this.httpClient.post(baseUrl + '/user', 
        JSON.stringify(signUpItem), httpOptions);
    }
}
