import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { AppointmentService } from '../service/appointment.service';
import { Appointment } from '../model/appointment';
import { ScheduleTermService } from '../service/schedule-term.service';

@Component({
  selector: 'app-scheduling-appointment',
  templateUrl: './scheduling-appointment.component.html',
  styleUrls: ['./scheduling-appointment.component.css']
})
export class SchedulingAppointmentComponent implements OnInit {
  avaliableTerms: any;
  appointment: Appointment;
  id: number;

  constructor(private route: ActivatedRoute,private router: Router, private appointmentService: AppointmentService, 
    private scheduleTermService: ScheduleTermService) { }

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
    console.log('Ovo je id appointmenta:', this.scheduleTermService.appointmentId )
    this.router.navigate(['reg-user-dashboard']);
  }
}
