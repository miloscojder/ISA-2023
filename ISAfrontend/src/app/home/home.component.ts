import { Component, OnInit } from '@angular/core';
import { RegisteredUser } from '../model/registeredUser';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisteredUserService } from '../service/registered-user.service';
import { CompanyServiceService } from '../service/company-service.service';
import { Company } from '../model/company';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
