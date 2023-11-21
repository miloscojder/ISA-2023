import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { Company } from './model/company';
import { CompanyComponent } from './company/company.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { ConfirmUserComponent } from './confirm-user/confirm-user.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'all-companies', component:CompanyComponent},
  {path: 'all-equipments', component:EquipmentComponent},
  {path: 'confirm-registration/:id', component: ConfirmUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
