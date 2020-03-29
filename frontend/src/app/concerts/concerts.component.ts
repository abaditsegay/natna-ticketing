import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-concerts',
  templateUrl: './concerts.component.html',
  styleUrls: ['./concerts.component.css']
})
export class ConcertsComponent {
  concertEvents = [
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
