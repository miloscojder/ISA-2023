import { ObserversModule } from '@angular/cdk/observers';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipment } from '../model/equipment';

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {
  url="http://localhost:8081/api/equipments";
  url1 = "http://localhost:8081/api/equipmentName";

  constructor(private http:HttpClient) { }
  
  getAllEquipment():Observable<Equipment[]>
  {
    return this.http.get<Equipment[]>(this.url);
  }

  findEquipmentByName(name: string): Observable<Equipment[]>
  {
    return this.http.get<Equipment[]>(`${this.url1}/${name}`);
  } 


}
