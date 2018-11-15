import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material";
import {DialogComponent} from "../dialog/dialog.component";
import {ApiService} from "../../shared/service/api.service";

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {


  public city: string;

  constructor(public dialog: MatDialog,
              private api: ApiService ) { }

  ngOnInit() {
  }

  openDialog(data: string): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: {city: data}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.city = "";
    });
  }

  searchCity(){
    this.api.getCities(this.city).subscribe((data:any) => {
      this.openDialog(data);
    });
  }
}
