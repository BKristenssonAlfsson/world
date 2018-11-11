import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private API_URL: string = "http://localhost:8080";

  constructor( private httpClient: HttpClient ) { }

  getContinents() {
    return this.httpClient.get(this.API_URL + "/world/world/continent");
  }
}

