import { Component, OnInit } from '@angular/core';
import { LoggedInInfo } from '../models/loggedin.information';

@Component({
  selector: 'account-overview',
  templateUrl: './account-overview.component.html',
  styleUrls: ['./account-overview.component.css']
})
export class AccountOverviewComponent {

  signedIndRole: string;


  setSignedInRole(loggedInInfo: LoggedInInfo) {
    this.signedIndRole = loggedInInfo.signedInUserRole;
  }

}
