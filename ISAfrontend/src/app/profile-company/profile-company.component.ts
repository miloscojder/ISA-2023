import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { Equipment } from '../model/equipment';
import { ActivatedRoute, Router } from '@angular/router';
import { CompanyServiceService } from '../service/company-service.service';
import { EquipmentService } from '../service/equipment.service';
import { ScheduleTermService } from '../service/schedule-term.service';

@Component({
  selector: 'app-profile-company',
  templateUrl: './profile-company.component.html',
  styleUrls: ['./profile-company.component.css']
})
export class ProfileCompanyComponent implements OnInit {

  id:number;
  company: Company;
  equipments: Equipment[];
  companyName: string;
  name: string;
  placeholder2: '';
  selectedEquipmentIds: number[] = [];

  constructor(private route: ActivatedRoute, private companyService: CompanyServiceService,
    private equipmentService: EquipmentService,private scheduleTermService: ScheduleTermService ,private router: Router ) { }

  ngOnInit(): void {
    this.loadCenter();
    this.ViewEquipmentsForThisProfileCompany();
  }
  
  loadCenter()
  {
    console.log('Ovo je rola', sessionStorage.getItem("role"), sessionStorage.getItem('token'));
    console.log('CompanyId i regUserId:', this.scheduleTermService.companyId, this.scheduleTermService.registeredUserId);
 
    this.id = this.route.snapshot.params['id'];
    this.companyService.getCompanyById(this.id)
    .subscribe(res => this.company = res)
  }
  
  ViewEquipmentsForThisProfileCompany()
  {
    console.log(this.route.snapshot.params['id']);
    this.companyService.getAllEquipmentByCompany(this.id)
    .subscribe(res => this.equipments = res)
  }
  
  findByNameEquipment()
  {
    this.companyService.findCompanyEquipmentByName(this.id, this.name)
    .subscribe(res => this.equipments = res)
  }

  toggleSelectionEquipment(equipmentId: number): void {
    const index = this.selectedEquipmentIds.indexOf(equipmentId);

    if(index === -1) {
      //Ako Id ne postoji u nizu, dodaj ga u niz
      this.selectedEquipmentIds.push(equipmentId);
    } else{
      //Ako Id vec postoji u nizu, ukloni  ga iz niza 
      this.selectedEquipmentIds.splice(index, 1);
    }
  }

  isSelectedEquipment(equipmentId: number): boolean{
    console.log(this.selectedEquipmentIds);
    //Provera da li je trenutni Id u nizu odabrane opreme, prikaz za html
    return this.selectedEquipmentIds.includes(equipmentId);

  }

  viewFreeTerm()
  {
    this.scheduleTermService.equipmentIds = this.selectedEquipmentIds;
    console.log('Selektovana oprema za termin:', this.selectedEquipmentIds);
    this.router.navigate(['schedule-appointment']);
  }
}
