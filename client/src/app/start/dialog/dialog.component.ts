import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  cityForm: FormGroup;

  constructor(public dialogRef: MatDialogRef<DialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: string,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.cityForm = this.formBuilder.group({
      cityName: [ {value: this.data["city"], disabled: true} ],
      country: [ {value: 'Temp', disabled: true} ],
      continent: [ {value: 'Try', disabled: true} ],
      population: [ {value: '54354', disabled: true} ]
    });
  }

}
