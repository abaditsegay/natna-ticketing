import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Location } from '@angular/common';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


import { SignUpService } from '../services/signup-service';
import { SignUpItem } from '../models/signup-model';
import { ResponseStatus } from '../models/response-status';
import { LoggedInInfo } from '../models/loggedin.information';

@Component({
  selector: 'service-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})

export class SignupComponent implements OnInit  {
  @Output() public loggedInInfo: EventEmitter<LoggedInInfo> = new EventEmitter();

  
  formSignUp: FormGroup;
  formSignIn: FormGroup;
  signUpData: SignUpItem;

  signUpStatus: ResponseStatus;
  registered: string = "";
  signupMessage: string = "";
 
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private signUpService: SignUpService,
    private modalService: NgbModal,
    private activatedRoute: ActivatedRoute,
    private router: Router
    ){}

  ngOnInit(){
    this.formSignUp = this.formBuilder.group({
      signUpRegisterationEmail: this.formBuilder.control(''),
      signUpRegisterationPassword: this.formBuilder.control(''),
      signUpConfirmRegisterationPassword: this.formBuilder.control('')
    });
    this.formSignIn = this.formBuilder.group({
      signInEmailAddress: this.formBuilder.control(''),
      signInPassword: this.formBuilder.control('')
    })
  }

  setSignInMessages(status: string, role: string, username: string){
    let loggedInInfoLocal: LoggedInInfo = {
      "signedInStatus": status,
      "signedInUserRole": role,
      "username": username
    };
  
    this.loggedInInfo.emit(loggedInInfoLocal);
  }
 
  signIn(signInItem) {
    //Call signIn REST API, if successful set signedIn to true and redirect to account overview page
    this.setSignInMessages("signedIn", "ADMIN", signInItem.signInEmailAddress);
    this.router.navigateByUrl('/accountoverview');  
  }

  signOut() {
    //Call signOut REST API, and redirect to home page
    this.setSignInMessages("", "", "");
    this.router.navigateByUrl('/');    
  }

  registerAccount(signUpItem) {
    this.signUpData = {
      "username": signUpItem.signUpRegisterationEmail,
      "password": signUpItem.signUpRegisterationPassword,
      "passwordConfirm": signUpItem.signUpConfirmRegisterationPassword,
      "role":"USER" //default Role
    };

  try {
    this.signUpService.signUp(this.signUpData)
      .subscribe(status => { 
        this.signUpStatus = status;
        if( typeof(status) === typeof(this.signUpStatus)) {
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
      }, (errors: any) => {
          this.registered = "failure";
          this.signupMessage = errors;
      });
    } catch(error) {
        this.registered = "failure";
        this.signupMessage = "Unknow error ocurred, please try again!";
    }

    this.formSignUp.reset();
    this.location.replaceState('');    
    //window.location.reload();
  }

  openModal() {
      const modalRef = this.modalService.open(SignupComponent);
      modalRef.componentInstance.user = "Test text";
    }

}