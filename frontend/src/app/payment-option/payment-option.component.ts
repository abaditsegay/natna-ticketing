
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

import { PaymentOptionsService } from './../services/payment-options.service';
import { PaymentOptionItem } from '../models/payment-options-model';
import { ResponseStatus } from '../models/response-status';

@Component({
  selector: 'event-payment-option',
  templateUrl: './payment-option.component.html',
  styleUrls: ['./payment-option.component.css']
})
export class PaymentOptionComponent  implements OnInit  {
  form: FormGroup;
  paymentOptionData: PaymentOptionItem;
  constructor(
    private location: Location, 
    private formBuilder: FormBuilder, 
    private paymentOptionsService: PaymentOptionsService,
    private activatedRoute: ActivatedRoute
    ){}
  ngOnInit(){
    this.form = this.formBuilder.group({
      paymentOptionFullName: this.formBuilder.control(''),
      paymentOptionBankName: this.formBuilder.control(''),
      paymentOptionBranch:this.formBuilder.control(''),
      paymentOptionAccountNumber:this.formBuilder.control(''),
      paymentOptionConfirmAccountNumber:this.formBuilder.control('')
    });
  }

  
  updateStatus: ResponseStatus;
  registered: string = "";
  signupMessage = "";

  addBankDetails(paymentOptions) {
    this.paymentOptionData = {
      "fullName": paymentOptions.paymentOptionFullName,
      "bankName": paymentOptions.paymentOptionBankName,
      "branchName": paymentOptions.paymentOptionBranch,
      "accountNumber": paymentOptions.paymentOptionAccountNumber,
     "confirmAccountNumber": paymentOptions.paymentOptionConfirmAccountNumber
    };

    this.paymentOptionsService.addPayment(this.paymentOptionData)
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
