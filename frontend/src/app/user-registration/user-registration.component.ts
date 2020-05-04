import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';


import { SignUpService } from '../services/signup-service';
import { SignUpItem } from '../models/signup-model';
import { CreateStatus } from '../models/create-status';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit  {
  formSignUp: FormGroup;
  signUpData: SignUpItem;
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private signUpService: SignUpService,
    private activatedRoute: ActivatedRoute
    ){}

  ngOnInit(){
    this.formSignUp = this.formBuilder.group({
      registerationEmail: this.formBuilder.control(''),
      registerationPassword: this.formBuilder.control(''),
      confirmRegisterationPassword: this.formBuilder.control('')
    });
  }
 
  signUpStatus: CreateStatus;
  registered: string = "";
  signupMessage = "";

  registerAccount(signUpItem) {
    this.signUpData = {
      "username": signUpItem.registerationEmail,
      "password": signUpItem.registerationPassword,
      "passwordConfirm": signUpItem.confirmRegisterationPassword,
      "role":"USER" //default Role
    };

  try {
    this.signUpService.signUp(this.signUpData)
      .subscribe(data => { 
        this.signUpStatus = data;
        if( typeof(data) === typeof(this.signUpStatus)) {
          if (this.signUpStatus.responseCode === '00') {
            this.registered = "success";
            this.signupMessage = "Successfully registered";
          } else {
            this.registered = "failure";
            this.signupMessage = "Unsuccessful, please try again!";
          }
        } else {
            this.registered = "failure";
            this.signupMessage = "Unsuccessful, please try again!";
        }
      }, (errors: any) => {
          this.registered = "failure";
          this.signupMessage = errors;
      });
    } catch(error) {
        this.registered = "failure";
        this.signupMessage = "Unknow error ocurred, please try again!";
    }

      this.location.replaceState('');    
    //window.location.reload();
  }
}
