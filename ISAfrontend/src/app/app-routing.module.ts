import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { Company } from './model/company';
import { CompanyComponent } from './company/company.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { ConfirmUserComponent } from './confirm-user/confirm-user.component';
import { HomeRegisteredUserComponent } from './home-registered-user/home-registered-user.component';
import { ProfileCompanyComponent } from './profile-company/profile-company.component';
import { SchedulingAppointmentComponent } from './scheduling-appointment/scheduling-appointment.component';
import { RegUserDashboardComponent } from './reg-user-dashboard/reg-user-dashboard.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'all-companies', component:CompanyComponent},
  {path: 'all-equipments', component:EquipmentComponent},
  {path: 'confirm-registration/:id', component: ConfirmUserComponent},
  {path: 'home-page', component:HomeRegisteredUserComponent},
  {path: 'profile-center/:id', component:ProfileCompanyComponent},
  {path: 'schedule-appointment', component:SchedulingAppointmentComponent},
  {path: 'reg-user-dashboard', component:RegUserDashboardComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
