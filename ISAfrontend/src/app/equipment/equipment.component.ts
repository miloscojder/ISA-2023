import { Component, OnInit } from '@angular/core';
import { Equipment } from '../model/equipment';
import { EquipmentService } from '../service/equipment.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.css']
})
export class EquipmentComponent implements OnInit {
  id: number;
  equipments: Equipment[];
  equipment: Equipment;
  name: string;
  placeholder2: '';

  constructor(private equipmentService: EquipmentService, private router: Router) { }

  ngOnInit(): void {
    this.viewAll();
  }

  viewAll()
  {
    this.equipmentService.getAllEquipment()
    .subscribe(res => this.equipments = res)
  }

  findByName()
  {
    this.equipmentService.findEquipmentByName(this.name)
    .subscribe(res => this.equipments = res)
  }
}
