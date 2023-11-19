import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from '../model/company';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {
  url="http://localhost:8081/api/companies";
  url1 = "http://localhost:8081/api/companyName";

  constructor(private http:HttpClient) { }
  
  getAllCompany():Observable<Company[]>
  {
    return this.http.get<Company[]>(this.url);
  }

  findCompanyByName(name: string): Observable<Company[]>
  {
    return this.http.get<Company[]>(`${this.url1}/${name}`);
  } 

}
