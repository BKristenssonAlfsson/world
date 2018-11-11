import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StartComponent } from "./start/start.component";
import { ContinentComponent } from "./start/continent/continent.component";
import { CountryComponent } from "./start/country/country.component";

const routes: Routes = [
  { path: '', component: StartComponent, children: [
      { path: 'continent', component: ContinentComponent },
      { path: 'country', component: CountryComponent }
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
