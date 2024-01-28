import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { RegisteredUser } from '../model/registeredUser';
import { RegisteredUserService } from '../service/registered-user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CompanyServiceService } from '../service/company-service.service';

@Component({
  selector: 'app-home-registered-user',
  templateUrl: './home-registered-user.component.html',
  styleUrls: ['./home-registered-user.component.css']
})
export class HomeRegisteredUserComponent implements OnInit {

  id : number;
  companies: Company[];
  registeredUser: RegisteredUser;
  registered_user_id: number;
  loginService: any;
  
  constructor(private route: ActivatedRoute, private registeredUserService: RegisteredUserService,
    private companyService: CompanyServiceService, private router: Router) { }

  ngOnInit(): void {
    this.viewAll();
  }

   
  viewAll()
  {
    this.companyService.getAllCompany()
    .subscribe(res => this.companies = res)
  }
}
