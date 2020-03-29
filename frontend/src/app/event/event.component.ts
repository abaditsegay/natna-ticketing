import { Component, Input } from '@angular/core';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent {

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
  ];
  theaterEvents = [
    {
      "name":"Theater",
      "imagePath":"assets/images/avatar3.png",
      "location":"Mekelle",
      "date": "March 25, 2020"
    },
    {
      "name":"Theater",
      "imagePath":"assets/images/avatar3.png",
      "location":"Wukro",
      "date": "March 25, 2020"
    },
    {
      "name":"Theater",
      "imagePath":"assets/images/avatar3.png",
      "location":"Adigrat",
      "date": "March 25, 2020"
    }
  ];
  sportEvents = [
    {
      "name":"Soccer",
      "imagePath":"assets/images/gana-ethio.jpg",
      "location":"Mekelle",
      "date": "March 25, 2020"
    },
    {
      "name":"Soccer",
      "imagePath":"assets/images/gana-ethio.jpg",
      "location":"Alamata",
      "date": "March 25, 2020"
    },
    {
      "name":"Soccer",
      "imagePath":"assets/images/gana-ethio.jpg",
      "location":"Adigrat",
      "date": "March 25, 2020"
    }
  ]
}
