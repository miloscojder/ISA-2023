import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from '../model/company';
import { Observable } from 'rxjs';
import { Equipment } from '../model/equipment';
@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {
  url="http://localhost:8081/api/companies";
  url1 = "http://localhost:8081/api/companyName";
  url2 = "http://localhost:8081/api/companyId";
  url3="http://localhost:8081/api/company/equipment";
  url4= "http://localhost:8081/api/company/equipment/equipmentName"

  constructor(private http:HttpClient) { }
  
  getAllCompany():Observable<Company[]>
  {
    return this.http.get<Company[]>(this.url);
  }

  findCompanyByName(name: string): Observable<Company[]>
  {
    return this.http.get<Company[]>(`${this.url1}/${name}`);
  } 
  
  getCompanyById(id:number):Observable<Company>
  {
    return this.http.get<Company> (`${this.url2}/${id}`)
  }

  getAllEquipmentByCompany(id:number):Observable<Equipment[]>
  {
    return this.http.get<Equipment[]> (`${this.url3}/${id}`)
  }

  findCompanyEquipmentByName(id: number, name: string): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${this.url4}/${id}/${name}`);
  }
}
