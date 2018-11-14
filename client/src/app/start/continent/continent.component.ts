import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../shared/service/api.service";
import {log} from "util";

@Component({
  selector: 'app-continent',
  templateUrl: './continent.component.html',
  styleUrls: ['./continent.component.css']
})
export class ContinentComponent implements OnInit {
  public continents: any[] = [];
  current_selected: string;
  countries_on_continent: any[] = [];

  constructor(private api: ApiService) {

    this.api.getContinents().subscribe((data: any) => {
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

    this.countries_on_continent.push("No continent selected");
  }

  ngOnInit() {
  }

  onSelection(e, v){
    this.api.showCountriesOnContinent(e.id).subscribe((data: any) => {
      this.countries_on_continent = data[0].country.map(o => {
        return o.name;
      });
      console.log(this.countries_on_continent);
    });
    this.current_selected = e.continent;
  }
}
