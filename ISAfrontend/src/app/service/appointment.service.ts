import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';
import { ScheduleTerm } from '../model/scheduleTerm';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  url = "http://localhost:8081/api/appointments";
  url1 = "http://localhost:8081/api/scheduledTerm";
  url2 = "http://localhost:8081/api/cancelTerm";
  url3 = "http://localhost:8081/api/can-make-reservation";

  constructor(private http: HttpClient) { }

  findAllTermsByRegisteredUser(id: number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(`${this.url1}/${id}`)
  }

  findAllAvailableTerms(id: number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(`${this.url}/${id}`)
  }

  cancelTerm(scheduleTerm: ScheduleTerm): Observable<Appointment>{
    console.log('Pokrenuta je f-ja za otkazivanje termina', scheduleTerm.appointmentId)
    return this.http.put<Appointment>(this.url2, scheduleTerm);
  }

  isUserHave3Penalities(id: number): Observable<boolean>{
    return this.http.get<boolean>(`${this.url3}/${id}`)
  }
}
