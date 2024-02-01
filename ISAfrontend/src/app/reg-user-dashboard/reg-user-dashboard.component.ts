import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from '../service/appointment.service';
import { Appointment } from '../model/appointment';
import { ScheduleTerm } from '../model/scheduleTerm';

@Component({
  selector: 'app-reg-user-dashboard',
  templateUrl: './reg-user-dashboard.component.html',
  styleUrls: ['./reg-user-dashboard.component.css']
})
export class RegUserDashboardComponent implements OnInit {
  id: number;
  allTerms: any;
  scheduleTerm: ScheduleTerm;
  equipmentsIds: number [] = [];
  constructor(private route: ActivatedRoute, private router: Router, private appointmentService: AppointmentService) {
    this.scheduleTerm = new ScheduleTerm({
      registeredUserId:0,
      companyId:0,
      appointmentId:0,
      equipmentIds: this.equipmentsIds})
   }

  ngOnInit(): void {
    this.viewSheduledAppointments();
  }
  viewSheduledAppointments(){
    this.id = Number(sessionStorage.getItem(`id`));
    this.appointmentService.findAllTermsByRegisteredUser(this.id)
    .subscribe(res => this.allTerms=res);
   
  }

  cancelAppointment(appId: number){
    this.scheduleTerm.appointmentId = appId;
    this.appointmentService.cancelTerm(this.scheduleTerm)
    .subscribe(() => {
      this.viewSheduledAppointments();
    });
  }
}
