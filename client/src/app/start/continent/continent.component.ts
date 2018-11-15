import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../shared/service/api.service";

@Component({
  selector: 'app-continent',
  templateUrl: './continent.component.html',
  styleUrls: ['./continent.component.css']
})
export class ContinentComponent implements OnInit {
  public continents: any[] = [];
  current_selected: string;
  countries_on_continent: object[] = [];
  countriesOne: object[] =[];
  countriesTwo: object[] =[];
  countriesThree: object[] =[];
  countriesFour: object[] =[];
  countriesFive: object[] =[];
  countriesSix: object[] =[];
  countriesSeven: object[] =[];
  countriesEight: object[] =[];

  constructor(private api: ApiService) {

    this.api.getContinents().subscribe((data: any) => {
      this.continents = data;
    });

/*    this.api.getLanguages().subscribe((data:any) => {
      console.log(data);
    });
  */
  }

  ngOnInit() {
  }

  onSelection(e, v){
    this.api.showCountriesOnContinent(e.id).subscribe((data: any) => {
      this.countries_on_continent = data[0].country.map(o => {
        return o.name;
      });
      console.log(data);
      this.countries_on_continent.sort();
      this.countriesOne = this.countries_on_continent.splice(0,9);
      this.countriesTwo = this.countries_on_continent.splice(0,9);
      this.countriesThree = this.countries_on_continent.splice(0,9);
      this.countriesFour = this.countries_on_continent.splice(0,9);
      this.countriesFive = this.countries_on_continent.splice(0,9);
      this.countriesSix = this.countries_on_continent.splice(0,9);
      this.countriesSeven = this.countries_on_continent.splice(0,9);
      this.countriesEight = this.countries_on_continent.splice(0,9);
    });
;
    this.current_selected = e.continent;
  }
}
