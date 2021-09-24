import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Myservice2Service, Appointments } from '../myservice2.service';

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.css']
})
export class AddAppointmentComponent implements OnInit {
  message: string;

  constructor(private myservice: Myservice2Service,private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(addappointment:Appointments):any{
    console.log(addappointment);
     this.myservice.addAppointment(addappointment).subscribe(data => {
      this.message=data});
  }

}