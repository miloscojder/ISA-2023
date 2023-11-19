import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { Router } from '@angular/router';
import { CompanyServiceService } from '../service/company-service.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  id:number;
  companies: Company[];
  company: Company;
  name: string;
  placeholder1: '';

  constructor(private companyService: CompanyServiceService, private router: Router) { }

  ngOnInit(): void {
    this.viewAll();
  }

  viewAll()
  {
    this.companyService.getAllCompany()
    .subscribe(res => this.companies = res)
  }

  findByName()
  {
    this.companyService.findCompanyByName(this.name)
    .subscribe(res => this.companies = res)
  }

}
