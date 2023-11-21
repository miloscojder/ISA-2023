import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = "http://localhost:8081/users/signup/async";
  url1 = "http://localhost:8081/users/api/confirm-registration";

  constructor( private http: HttpClient) { }

  sendEmail(newUser: User): Observable<User> {
    return this.http.post<User>(this.url, newUser);
  }

 /* activateById(newUser: User): Observable<User>{
    return this.http.post<User>(this.url1, newUser)
  }*/
  activateById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url1}/${id}`);
  }
}
