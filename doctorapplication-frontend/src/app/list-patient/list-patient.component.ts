import { Component, OnInit } from '@angular/core';
import { Myservice1Service, Patients } from '../myservice1.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-patient',
  templateUrl: './list-patient.component.html',
  styleUrls: ['./list-patient.component.css']
})
export class ListPatientComponent implements OnInit {
  message: string;
  patients: Patients[];
  constructor(private myservice: Myservice1Service, private router: Router) {}

  ngOnInit(): any {
    this.myservice.getPatients().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }
  handleSuccessfulResponse(response) {
    this.patients = response;
  }
  update(updatepatient: Patients) {
    this.myservice.update(updatepatient);
    this.router.navigate(['/updatepatient']); 
  }
  delete(deletepatient: Patients): any {
    this.myservice.delete(deletepatient.patient_id).subscribe(data => {
      this.message = data
    });
    this.router.navigate(['/listpatient']);
  }

}