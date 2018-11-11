import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../shared/service/api.service";

@Component({
  selector: 'app-continent',
  templateUrl: './continent.component.html',
  styleUrls: ['./continent.component.css']
})
export class ContinentComponent implements OnInit {

  private continents: any[] = [];

  constructor(private api: ApiService) {
    this.api.getContinents().subscribe((data: any) => {
      this.continents = data;
      console.log(data);
    });

    this.api.getCities().subscribe((data: any) => {
      console.log(data);
    });
  }

  ngOnInit() {
    this.getContinents();
  }

  getContinents() {

  }


}
