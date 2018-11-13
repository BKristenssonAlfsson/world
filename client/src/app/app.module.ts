import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { StartComponent } from './start/start.component';
import { MaterialModule } from "./shared/material/material.module";
import { ContinentComponent } from './start/continent/continent.component';
import { CountryComponent } from './start/country/country.component';
import { HomeComponent } from './start/home/home.component';
import { HttpClientModule } from "@angular/common/http";
import { ApiService } from "./shared/service/api.service";
import { Url } from "./shared/service/url";
import { ReactiveFormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    StartComponent,
    ContinentComponent,
    CountryComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ApiService, Url],
  bootstrap: [AppComponent]
})
export class AppModule { }
