import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-theaters',
  templateUrl: './theaters.component.html',
  styleUrls: ['./theaters.component.css']
})
export class TheatersComponent {
  
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
]
}
