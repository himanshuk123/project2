import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, Doctors } from '../myservice.service';

@Component({
  selector: 'app-update-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit {
  message: string;

  constructor(private myservice: MyserviceService,private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(adddoc:Doctors):any{
    console.log(adddoc);
     this.myservice.addDoctor(adddoc).subscribe(data => {
      this.message=data});
  }
}