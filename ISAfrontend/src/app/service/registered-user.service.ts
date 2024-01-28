import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from '../model/company';

@Injectable({
  providedIn: 'root'
})
export class RegisteredUserService {
  url="http://localhost:8081/api/companies";

  constructor(private http:HttpClient) { }
    getAllCompany(): Observable<Company[]>
    {
      return this.http.get<Company[]>(this.url);
    }
  
}

