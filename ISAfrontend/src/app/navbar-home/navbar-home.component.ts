import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-navbar-home',
  templateUrl: './navbar-home.component.html',
  styleUrls: ['./navbar-home.component.css']
})
export class NavbarHomeComponent implements OnInit {

 
username: any;
  dash_url = '/';
  id: any;
  role: any;

  @Output()
  LogOut: EventEmitter<void> = new EventEmitter();

  constructor(private _http: HttpClient, private loginService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');
  }

  logOut() {
    this.loginService.logOut();
    this.LogOut.next();
    this.router.navigate(['']);
  }

  showDashboard() {
    this.id = sessionStorage.getItem('id');
    this.role = sessionStorage.getItem('role');
    if (this.role == 'Owner') {
      this.router.navigate(['owner', this.id]);

    } else if (this.role == 'Instructor') {
      this.router.navigate(['instructors', this.id]);
    } else if (this.role == 'CottageOwner') {
      this.router.navigate(['cottageOwner', this.id]);

    } else if (this.role == 'Admin' || this.role == 'SysAdmin') {

      this.router.navigate(['admin', this.id]);
    } else if (this.role == 'BoatOwner') {
    this.router.navigate(['boatOwner', this.id]);
    }
  }

}
