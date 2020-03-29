import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { HttpClientModule }    from '@angular/common/http';


@Component({
  selector: 'service-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent  {
  data = "This is a test data";

  constructor(private location: Location) { }
 
  signedIn = false;

  signIn(signInItem) {
    console.log(signInItem);
    //Call signIn REST API, if successful set signedIn to true and redirect to account overview page
    this.signedIn = true;
    this.location.replaceState('/accountoverview');    
    window.location.reload();
  }

  registerAccount(registerAccountItem) {
    console.log(registerAccountItem);
    this.location.replaceState('');    
    window.location.reload();
  }
}
