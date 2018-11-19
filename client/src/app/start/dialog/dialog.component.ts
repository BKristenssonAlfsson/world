import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup} from "@angular/forms";
import {City} from "../../shared/model/city.model";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  cityForm: FormGroup;
  city = new City('', '', '', '', '');

  constructor(public dialogRef: MatDialogRef<DialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: string,
              private formBuilder: FormBuilder) {

    const temp = Object.values(this.data);
    console.log(this.data);
    this.city.continent = temp[0][0]['continent'].continent;
    this.city.country = temp[0][0]['country'].name;
    this.city.name = temp[0][0]['name'];
    this.city.population = temp[0][0]['population'];

  }

  ngOnInit() {
    this.cityForm = this.formBuilder.group({
      cityName: [ {value: this.city.name, disabled: true} ],
      country: [ {value: this.city.country, disabled: true} ],
      continent: [ {value: this.city.continent, disabled: true} ],
      population: [ {value: this.city.population, disabled: true} ]
    });
  }
}
