import {Component, OnInit, ViewChild, ViewChildren} from '@angular/core';
import {ApiService} from "../../shared/service/api.service";
import {MatPaginator, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {
  allCountries: any[] = [];
  columns: string[] = ['Country', 'Continent'];
  dataSource: MatTableDataSource;

  @ViewChildren(MatPaginator) paginator: MatPaginator;

  constructor(private api: ApiService) {
    this.api.getCountries().subscribe((data: any) => {
      console.log(data);
      this.allCountries = data;
      this.allCountries.sort();
      this.dataSource = new MatTableDataSource<>(this.allCountries);
   //   this.dataSource.paginator = this.paginator;
    });
  }

  ngOnInit() {
  }

}
