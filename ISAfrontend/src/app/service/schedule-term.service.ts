import { Injectable } from '@angular/core';
import { Equipment } from '../model/equipment';
import { ScheduleTerm } from '../model/scheduleTerm';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';

@Injectable({
  providedIn: 'root'
})
export class ScheduleTermService {


  //scheduleTerm: ScheduleTerm;
  companyId: number;
  registeredUserId: number;
  appointmentId: number;
  equipmentIds: number[] = [];
  equipments: Equipment[];

  url = "http://localhost:8081/api/scheduleTerm";

  constructor(private http:HttpClient) { }

  scheduleTermByUser(scheduleTerm: ScheduleTerm): Observable<Appointment>{
    return this.http.put<Appointment>(this.url, scheduleTerm);
  }

}
