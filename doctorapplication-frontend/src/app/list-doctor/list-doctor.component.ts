import { Component, OnInit } from '@angular/core';
import { MyserviceService, Doctors } from '../myservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-doctor',
  templateUrl: './list-doctor.component.html',
  styleUrls: ['./list-doctor.component.css']
})
export class ListDoctorComponent implements OnInit {
  message: string;
  doctors: Doctors[];
  constructor(private myservice: MyserviceService, private router: Router) {
  }

  ngOnInit(): any {
    this.myservice.getDoctors().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }
  handleSuccessfulResponse(response) {
    this.doctors = response;
  }
  update(updatedoctor: Doctors) {
    this.myservice.update(updatedoctor);
    this.router.navigate(['/updatedoc']); 
  }
  delete(deletedoctor: Doctors): any {
    this.myservice.delete(deletedoctor.doctor_id).subscribe(data => {
      this.message = data
    });
    this.router.navigate(['/listdoc']);
  }
}
