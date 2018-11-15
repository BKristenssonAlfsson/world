import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Url} from "./url";
import {Headers} from "./headers";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor( private httpClient: HttpClient,
               private url: Url) { }

  getContinents() {
    return this.httpClient.get(this.url.getBaseUrl() + this.url.getContinents(), { headers : Headers.HeaderJSON() } );
  }

  getCities(city: string) {
    return this.httpClient.get(this.url.getBaseUrl() + this.url.getCities() + "/" + city, { headers : Headers.HeaderJSON() } );
  }

  getCountries() {
    return this.httpClient.get(this.url.getBaseUrl() + this.url.getCountries(), { headers: Headers.HeaderJSON() } );
  }

  getLanguages() {
    return this.httpClient.get(this.url.getBaseUrl() + this.url.getLanguages(), { headers: Headers.HeaderJSON() } );
  }

  showCountriesOnContinent(continent : string) {
    return this.httpClient.get(this.url.getBaseUrl() + this.url.getContinents() + "/" + continent, { headers: Headers.HeaderJSON() } );
  }
}

