import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Myservice2Service, Appointments } from '../myservice2.service';

@Component({
  selector: 'app-update-appointment',
  templateUrl: './update-appointment.component.html',
  styleUrls: ['./update-appointment.component.css']
})
export class UpdateAppointmentComponent implements OnInit {
  message: string;

  constructor(private myservice2: Myservice2Service,private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(addappointment:Appointments):any{
    console.log(addappointment);
     this.myservice2.addAppointment(addappointment).subscribe(data => {
      this.message=data});
  }

}