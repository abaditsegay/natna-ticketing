import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'event-payment-option',
  templateUrl: './payment-option.component.html',
  styleUrls: ['./payment-option.component.css']
})
export class PaymentOptionComponent {

  addPaymentOptions() {
    console.log("Added Payment Option");
  }
}
