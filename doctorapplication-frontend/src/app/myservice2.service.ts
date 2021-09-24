import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Myservice2Service {
  updateappointment: Appointments;
  constructor(private httpService: HttpClient) { }
  public getAppointments() {
    console.log("ins service get appointments");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.get<Appointments>(" http://localhost:8586/api/appointments");
  }

  public addAppointment(addappointment: Appointments) {
    console.log("ins service add");
    console.log(addappointment);
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post(" http://localhost:8586/api/appointments", addappointment,  { headers, responseType: 'text'});
  }
  
  public update(updateappointment: Appointments) {
    this.updateappointment = updateappointment;
  }
  public updateMethod() {
    return this.updateappointment;
  }
  public onUpdate(updateappointment: Appointments) {
    console.log("ins service update");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.put(" http://localhost:8586/api/appointments/{appointment_id}", updateappointment,  { headers, responseType: 'text'});
  }
  delete(id: number) {
    console.log("ins service delete");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.delete("http://localhost:8586/api/appointments/{appointment_id}" +id,  { headers, responseType: 'text'});
  }

}
export class Appointments {
  appointment_id: number;
  appointment_details: string;
  appointment_date: string;
  appointment_status: string;
  appointment_time: number;
}