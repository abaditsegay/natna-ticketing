import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'account-settings',
  templateUrl: './account-settings.component.html',
  styleUrls: ['./account-settings.component.css']
})
export class AccountSettingsComponent  {

  updateAccountDetail(){
    console.log("Account Detail updated successfully");
  }
}
