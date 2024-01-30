import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { RegisteredUser } from '../model/registeredUser';
import { RegisteredUserService } from '../service/registered-user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CompanyServiceService } from '../service/company-service.service';
import { ScheduleTerm } from '../model/scheduleTerm';
import { ScheduleTermService } from '../service/schedule-term.service';
import { Equipment } from '../model/equipment';

@Component({
  selector: 'app-home-registered-user',
  templateUrl: './home-registered-user.component.html',
  styleUrls: ['./home-registered-user.component.css']
})
export class HomeRegisteredUserComponent implements OnInit {

  id : number;
  companies: Company[];
  company_id: number;
  registeredUser: RegisteredUser;
  registered_user_id: number;
  loginService: any;
  scheduleTerm: ScheduleTerm;
  equipmentss: Equipment[];
  
  constructor(private route: ActivatedRoute, private registeredUserService: RegisteredUserService,
    private companyService: CompanyServiceService, private scheduleTermService: ScheduleTermService, private router: Router) {
      this.scheduleTerm = new ScheduleTerm({
        registeredUserId:0,
        companyId:0,
        appointentId:0,
        equipments:this.equipmentss

      })
     }

  ngOnInit(): void {
    this.viewAll();
   
  }

   
  viewAll()
  {
    this.companyService.getAllCompany()
    .subscribe(res => this.companies = res)
  }

  goToCompany(companyId: number)
  {
    this.scheduleTermService.registeredUserId = Number(sessionStorage.getItem(`id`));
    this.scheduleTermService.companyId = Number(companyId);
    console.log('CompanyId i regUserId:', this.scheduleTermService.companyId, this.scheduleTermService.registeredUserId);
    this.router.navigate(['profile-center', companyId]);
  }
}
