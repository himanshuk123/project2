import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Myservice1Service {
  updatepatient: Patients;
  constructor(private httpService: HttpClient) { }
  public getPatients() {
    console.log("ins service get patients");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.get<Patients>(" http://localhost:8586/api/patients");
  }

  public addPatient(addpatient: Patients) {
    console.log("ins service add");
    console.log(addpatient);
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post(" http://localhost:8586/api/patients", addpatient,  { headers, responseType: 'text'});
  }
  
  public update(updatepatient: Patients) {
    this.updatepatient = updatepatient;
  }
  public updateMethod() {
    return this.updatepatient;
  }
  public onUpdate(updatepatient: Patients) {
    console.log("ins service update");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.put(" http://localhost:8586/api/patients/{patient_id}", updatepatient,  { headers, responseType: 'text'});
  }
  delete(id: number) {
    console.log("ins service delete");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.delete("http://localhost:8586/api/patients/{patient_id}" +id,  { headers, responseType: 'text'});
  }

}
export class Patients {
  patient_id: number;
  patient_name: string;
  patient_email: string;
  patient_age: string;
  patient_city: string;
  patient_gender: string;
  patient_phonenumber: string;
}