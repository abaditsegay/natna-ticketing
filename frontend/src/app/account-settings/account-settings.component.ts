import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

import { AccountService } from './../services/account.service';
import { ProfileItem } from '../models/profile-model';
import { ProfileByNamesItem } from '../models/profile-model-names';
import { ProfileByEmailItem } from '../models/profile-model-email';
import { ProfileByPhoneItem } from '../models/profile-model-phone';
import { ProfileByLocationItem } from '../models/profile-model-location';
import { ResponseStatus } from '../models/response-status';

@Component({
  selector: 'account-settings',
  templateUrl: './account-settings.component.html',
  styleUrls: ['./account-settings.component.css']
})
export class AccountSettingsComponent  implements OnInit  {
  form: FormGroup;
  profileData: ProfileItem;
  profileDataNames: ProfileByNamesItem;
  profileDataEmails: ProfileByEmailItem;
  profileDataphone: ProfileByPhoneItem;
  profileDataLocation: ProfileByLocationItem;
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private accountService: AccountService,
    private activatedRoute: ActivatedRoute
    ){}
  ngOnInit(){
    this.form = this.formBuilder.group({
      accountOverviewFirstName: this.formBuilder.control(''),
      accountOverviewLastName: this.formBuilder.control(''),
      accountOverviewEmailAddress: this.formBuilder.control(''),
      accountOverviewPhoneNumber: this.formBuilder.control(''),
      accountSettingsCity: this.formBuilder.control(''),
      accountOverviewRegion: this.formBuilder.control('')
    });
  }

  
  updateStatus: ResponseStatus;
  registered: string = "";
  signupMessage = "";

  updateProfile(profile) {
    this.profileData = {
      "firstName": profile.accountOverviewFirstName,
      "lastName": profile.accountOverviewLastName,
      "email": profile.accountOverviewEmailAddress,
      "phoneNumber": profile.accountOverviewPhoneNumber,
      "region": profile.accountOverviewRegion,
      "city": profile.accountSettingsCity
    };

    this.accountService.updateProfile(this.profileData)
      .subscribe(data => { 
        this.updateStatus = data;
        if( typeof(data) === typeof(this.updateStatus)) {
          if (this.updateStatus.responseCode === '00') {
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

  updateProfileByNames(profile) {
    this.profileDataNames = {
      "firstName": profile.accountOverviewFirstName,
      "lastName": profile.accountOverviewLastName
    };

    this.accountService.updateFirstLastNames(this.profileDataNames)
      .subscribe(data => { 
        this.updateStatus = data;
        if( typeof(data) === typeof(this.updateStatus)) {
          if (this.updateStatus.responseCode === '00') {
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
  
  updateProfileByEmail(profile) {
    this.profileDataEmails = {
     "email": profile.accountOverviewEmailAddress
    };

    this.accountService.updateProfileByEmail(this.profileDataEmails)
      .subscribe(data => { 
        this.updateStatus = data;
        if( typeof(data) === typeof(this.updateStatus)) {
          if (this.updateStatus.responseCode === '00') {
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

  updateProfileByPhoneNumber(profile) {
    this.profileDataphone = {
     "phoneNumber": profile.accountOverviewPhoneNumber
    };

    this.accountService.updateProfileByPhonenumber(this.profileDataphone)
      .subscribe(data => { 
        this.updateStatus = data;
        if( typeof(data) === typeof(this.updateStatus)) {
          if (this.updateStatus.responseCode === '00') {
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
    // window.location.reload();
  }

  updateProfileByLocation(profile) {
    this.profileDataLocation = {
      "region": profile.accountOverviewRegion,
      "city": profile.accountSettingsCity
    };

    this.accountService.updateProfileByLocation(this.profileDataLocation)
      .subscribe(data => { 
        this.updateStatus = data;
        if( typeof(data) === typeof(this.updateStatus)) {
          if (this.updateStatus.responseCode === '00') {
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