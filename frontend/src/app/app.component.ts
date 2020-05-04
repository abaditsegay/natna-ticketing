import { Component, OnInit } from '@angular/core';
import { LoggedInInfo } from './models/loggedin.information';
import { SearchCriteria } from './models/search-criteria';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Natna Ticket System';
  
  //Used for search form
  formSearch: FormGroup;
  searchCriteria: SearchCriteria;

  signInStatusFromChild: string;
  signedIndRole: string;
  username: string;

  constructor(private formBuilder: FormBuilder){}

  ngOnInit() {
    this.formSearch = this.formBuilder.group({
      searchText: this.formBuilder.control(''),
      selectedCity: this.formBuilder.control(''),
      searchEventType: this.formBuilder.control(''),
      searchEventDate: this.formBuilder.control('')
    });
  }

  //Recieves message from child modal 
  setSignInMessages(loggedInInfo: LoggedInInfo) {
    this.signInStatusFromChild = loggedInInfo.signedInStatus;
    this.signedIndRole = loggedInInfo.signedInUserRole;
    this.username = loggedInInfo.username;
  }

  searchEvents(searchCriteria) {
    console.log(searchCriteria);
  }

}
