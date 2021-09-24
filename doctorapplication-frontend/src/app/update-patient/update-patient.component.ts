import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Myservice1Service, Patients } from '../myservice1.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {
  message: string;

  constructor(private myservice: Myservice1Service,private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(addpatient:Patients):any{
    console.log(addpatient);
     this.myservice.addPatient(addpatient).subscribe(data => {
      this.message=data});
  }

}