import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../shared/service/api.service";

@Component({
  selector: 'app-continent',
  templateUrl: './continent.component.html',
  styleUrls: ['./continent.component.css']
})
export class ContinentComponent implements OnInit {

  private continents: any[] = [];

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.getContinents();
  }

  getContinents() {
    this.api.getContinents().subscribe((data: Array<any>) => {
      this.continents = data;
      console.log(data);
    });
  }


}
