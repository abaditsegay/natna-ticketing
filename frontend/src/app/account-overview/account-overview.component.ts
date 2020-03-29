import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'account-overview',
  templateUrl: './account-overview.component.html',
  styleUrls: ['./account-overview.component.css']
})
export class AccountOverviewComponent {

  eventsYouMayLike = [
    {
      "name":"Concert",
      "imagePath":"assets/images/wazema-concert.jpg",
      "location":"Shire",
      "date": "March 25, 2020"
    },
    {
      "name":"Concert",
      "imagePath":"assets/images/wazema-concert.jpg",
      "location":"Alamata",
      "date": "March 25, 2020"
    },
    {
      "name":"Concert",
      "imagePath":"assets/images/wazema-concert.jpg",
      "location":"Adigrat",
      "date": "March 25, 2020"
    }
]

}
