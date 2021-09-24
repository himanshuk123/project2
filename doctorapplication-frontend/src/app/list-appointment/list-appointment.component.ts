import { Component, OnInit } from '@angular/core';
import { Myservice2Service, Appointments } from '../myservice2.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-appointment',
  templateUrl: './list-appointment.component.html',
  styleUrls: ['./list-appointment.component.css']
})
export class ListAppointmentComponent implements OnInit {
  message: string;
  appointments: Appointments[];
  constructor(private myservice: Myservice2Service, private router: Router) {}

  ngOnInit(): any {
    this.myservice.getAppointments().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }
  handleSuccessfulResponse(response) {
    this.appointments = response;
  }
  update(updateappointment: Appointments) {
    this.myservice.update(updateappointment);
    this.router.navigate(['/updateappointment']); 
  }
  delete(deleteappointment: Appointments): any {
    this.myservice.delete(deleteappointment.appointment_id).subscribe(data => {
      this.message = data
    });
    this.router.navigate(['/listappointment']);
  }

}