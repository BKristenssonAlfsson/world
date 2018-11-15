import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StartComponent } from "./start/start.component";
import { ContinentComponent } from "./start/continent/continent.component";
import { CountryComponent } from "./start/country/country.component";
import {CityComponent} from "./start/city/city.component";
import {LanguageComponent} from "./start/language/language.component";
import {UserComponent} from "./start/user/user.component";

const routes: Routes = [
  { path: '', component: StartComponent, children: [
      { path: 'continent', component: ContinentComponent },
      { path: 'country', component: CountryComponent },
      { path: 'city', component: CityComponent },
      { path: 'language', component: LanguageComponent },
      { path: 'login', component: UserComponent }
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
