import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from '../service/appointment.service';
import { Appointment } from '../model/appointment';

@Component({
  selector: 'app-reg-user-dashboard',
  templateUrl: './reg-user-dashboard.component.html',
  styleUrls: ['./reg-user-dashboard.component.css']
})
export class RegUserDashboardComponent implements OnInit {
  id: number;
  allTerms: any;
  constructor(private route: ActivatedRoute, private router: Router, private appointmentService: AppointmentService) { }

  ngOnInit(): void {
    this.viewSheduledAppointments();
  }
  viewSheduledAppointments(){
    this.id = Number(sessionStorage.getItem(`id`));
    this.appointmentService.findAllTermsByRegisteredUser(this.id)
    .subscribe(res => this.allTerms=res);
   
  }
}
