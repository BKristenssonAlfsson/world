import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../shared/service/api.service";

@Component({
  selector: 'app-continent',
  templateUrl: './continent.component.html',
  styleUrls: ['./continent.component.css']
})
export class ContinentComponent implements OnInit {
  public continents: any[] = [];
  current_selected: string;

  constructor(private api: ApiService) {

    this.api.getContinents().subscribe((data: any) => {
      console.log(data);
      this.continents = data;
    });

    this.api.getCities().subscribe((data: any) => {
      console.log(data);
    });

    this.api.getCountries().subscribe((data: any) => {
      console.log(data);
    });

    this.api.getLanguages().subscribe((data:any) => {
      console.log(data);
    });
  }

  ngOnInit() {
  }

  onSelection(e, v){
    this.api.showDetailsAboutContinent(e.id).subscribe((data: any) => {
      console.log(data);
    });
    this.current_selected = e.continent;
  }

}
