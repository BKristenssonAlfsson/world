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

  getCities() {
    return this.httpClient.get(this.url.getBaseUrl() + this.url.getCities(), { headers : Headers.HeaderJSON() } );
  }
}

