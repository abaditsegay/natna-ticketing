import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent {
  
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
