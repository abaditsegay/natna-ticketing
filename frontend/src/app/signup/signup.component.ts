import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';


import { SignUpService } from '../services/signup.service';
import { SignUpItem } from '../models/signup-model';
import { ResponseStatus } from '../models/response-status';


@Component({
  selector: 'service-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit  {
  form: FormGroup;
  signUpData: SignUpItem;
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private signUpService: SignUpService,
    private activatedRoute: ActivatedRoute
    ){}

  ngOnInit(){
    this.form = this.formBuilder.group({
      registerationEmail: this.formBuilder.control(''),
      registerationPassword: this.formBuilder.control(''),
      confirmRegisterationPassword: this.formBuilder.control('')
    });
  }
 
  signedIn = false;
  signUpStatus: ResponseStatus;
  registered: string = "";
  signupMessage = "";

  signIn(signInItem) {
    console.log(signInItem);
    //Call signIn REST API, if successful set signedIn to true and redirect to account overview page
    this.signedIn = true;
    this.location.replaceState('/accountoverview');    
    window.location.reload();
  }

  registerAccount(signUpItem) {
    this.signUpData = {
      "username": signUpItem.registerationEmail,
      "password": signUpItem.registerationPassword,
      "passwordConfirm": signUpItem.confirmRegisterationPassword,
      "role":"USER" //default Role
    };

    this.signUpService.signUp(this.signUpData)
      .subscribe(data => { 
        this.signUpStatus = data;
        if( typeof(data) === typeof(this.signUpStatus)) {
          if (this.signUpStatus.responseCode === '00') {
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

      this.location.replaceState('');    
    //window.location.reload();
  }

}