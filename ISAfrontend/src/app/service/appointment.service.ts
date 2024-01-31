import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  url = "http://localhost:8081/api/appointments";
  constructor(private http: HttpClient) { }

  findAllAvailableTerms(id: number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(`${this.url}/${id}`)
  }
}
