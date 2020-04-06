import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms'
import { SignUpService } from '../services/signup.service';


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
    private signUpService: SignUpService
    ){}

  ngOnInit(){
    this.form = this.formBuilder.group({
      registerationEmail: this.formBuilder.control(''),
      registerationPassword: this.formBuilder.control(''),
      confirmRegisterationPassword: this.formBuilder.control('')
    });
  }
 
  signedIn = false;

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
      "roleType":"Admin2" //default Role
    };

    this.signUpService.signUp(this.signUpData)
      .subscribe(response => {
        console.log(response);
      })
    console.log(signUpItem);
    this.location.replaceState('');    
    window.location.reload();
  }
}

interface SignUpItem {
  username: string,
  password: string,
  passwordConfirm: string,
  roleType: string
};