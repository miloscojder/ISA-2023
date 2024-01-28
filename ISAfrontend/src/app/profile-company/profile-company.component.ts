import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { Equipment } from '../model/equipment';
import { ActivatedRoute, Router } from '@angular/router';
import { CompanyServiceService } from '../service/company-service.service';
import { EquipmentService } from '../service/equipment.service';

@Component({
  selector: 'app-profile-company',
  templateUrl: './profile-company.component.html',
  styleUrls: ['./profile-company.component.css']
})
export class ProfileCompanyComponent implements OnInit {

  id:number;
  company: Company;
  equipments: Equipment[];

  constructor(private route: ActivatedRoute, private companyService: CompanyServiceService,
    private equipmentService: EquipmentService, private router: Router ) { }

  ngOnInit(): void {
  }
  
  loadCenter()
  {
    this.id = this.route.snapshot.params['id'];
    this.companyService.getCompanyById(this.id)
    .subscribe(res => this.company = res)
  }
  
  ViewEquipmentsForThisProfileCompany()
  {
    this.companyService.getAllEquipmentByCompany(this.id)
    .subscribe(res => this.equipments = res)
  }

}
