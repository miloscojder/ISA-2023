import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  url = "http://localhost:8081/api/appointments";
  url1 = "http://localhost:8081/api/scheduledTerm";


  constructor(private http: HttpClient) { }

  findAllTermsByRegisteredUser(id: number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(`${this.url1}/${id}`)
  }

  findAllAvailableTerms(id: number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(`${this.url}/${id}`)
  }
}
