import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Myservice1Service, Patients } from '../myservice1.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
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