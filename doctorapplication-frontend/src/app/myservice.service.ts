import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyserviceService {
  updatedoctor: Doctors;
  constructor(private httpService: HttpClient) { }
  public getDoctors() {
    console.log("ins service get doctors");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.get<Doctors>(" http://localhost:8586/api/doctors");
  }

  public addDoctor(adddoctor: Doctors) {
    console.log("ins service add");
    console.log(adddoctor);
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post(" http://localhost:8586/api/doctors", adddoctor,  { headers, responseType: 'text'});
  }
  
  public update(updatedoctor: Doctors) {
    this.updatedoctor = updatedoctor;
  }
  public updateMethod() {
    return this.updatedoctor;
  }
  public onUpdate(updatedoctor: Doctors) {
    console.log("ins service update");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.put(" http://localhost:8586/api/doctors/{doctor_id}", updatedoctor,  { headers, responseType: 'text'});
  }
  delete(id: number) {
    console.log("ins service delete");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.delete("http://localhost:8586/api/doctors/{doctor_id}" +id,  { headers, responseType: 'text'});
  }

}
export class Doctors {
  doctor_id: number;
  doctor_name: string;
  doctor_city: string;
  doctor_email: string;
  doctor_experience: number;
  doctor_gender: string;
  doctor_phonenumber: string;
  doctor_specialization: string;
}