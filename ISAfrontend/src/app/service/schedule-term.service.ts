import { Injectable } from '@angular/core';
import { Equipment } from '../model/equipment';
import { ScheduleTerm } from '../model/scheduleTerm';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ScheduleTermService {


  //scheduleTerm: ScheduleTerm;
  companyId: number;
  registeredUserId: number;
  appointmentId: number;
  equipments: Equipment[];

  constructor(private http:HttpClient) { }


}
