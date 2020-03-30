import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'account-settings',
  templateUrl: './account-settings.component.html',
  styleUrls: ['./account-settings.component.css']
})
export class AccountSettingsComponent  {

  updateAccountDetail(accountSettingsItem){
    console.log(accountSettingsItem);
  }

  //Static List of Regions
  listOfRegions = ["Tigray","Amara","Afar","Oromia", "Somalia","Gambela"]
}
