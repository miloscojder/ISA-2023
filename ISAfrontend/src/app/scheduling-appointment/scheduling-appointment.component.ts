import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { AppointmentService } from '../service/appointment.service';
import { Appointment } from '../model/appointment';
import { ScheduleTermService } from '../service/schedule-term.service';
import { ScheduleTerm } from '../model/scheduleTerm';

@Component({
  selector: 'app-scheduling-appointment',
  templateUrl: './scheduling-appointment.component.html',
  styleUrls: ['./scheduling-appointment.component.css']
})
export class SchedulingAppointmentComponent implements OnInit {
  avaliableTerms: any;
  appointment: Appointment;
  id: number;
  scheduleTerm: ScheduleTerm;
  equipmentsIds: number [];

  constructor(private route: ActivatedRoute,private router: Router, private appointmentService: AppointmentService, 
    private scheduleTermService: ScheduleTermService) {
      this.scheduleTerm = new ScheduleTerm({
      registeredUserId:0,
      companyId:0,
      appointmentId:0,
      equipmentIds: this.equipmentsIds

    }) }

  ngOnInit(): void {
    this.viewAppointent();
  }

  viewAppointent(){
    this.id = this.scheduleTermService.companyId;
    this.appointmentService.findAllAvailableTerms(this.id)
    .subscribe(res => this.avaliableTerms=res);
  }
  toggleSelectionAppointment(appointmentId: number){
    this.scheduleTermService.appointmentId = appointmentId;
    console.log('Ovo je id appointmenta:', this.scheduleTermService.appointmentId);
    this.scheduleTerm.appointmentId = this.scheduleTermService.appointmentId;
    this.scheduleTerm.companyId = this.scheduleTermService.companyId;
    this.scheduleTerm.equipmentIds = this.scheduleTermService.equipmentIds;
    this.scheduleTerm.registeredUserId = this.scheduleTermService.registeredUserId;
    this.scheduleTermService.scheduleTermByUser(this.scheduleTerm)
    .subscribe(() => {
      this.router.navigate(['reg-user-dashboard']);
    });

  }
}
