import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  newUser:User;
  users:User[];

  constructor(private registrationService:RegistrationService) 
  {
      this.newUser = new User
      (
        {
          id: 6,
          firstName:"",
          lastName: "",
          email: "",
          username:"",
          password:"",
          mobile:"",
          enabled:false,
          role:"",
          authorities : []
        }
      );

      this.users = [];

  }

  ngOnInit(): void 
  {
    //this.reloadData();
  }

  /*reloadData()
  {
    this.registrationService.getUsers()
    .subscribe(res => this.users=res);
  }*/

  //Osvezavanje podataka nakon novog USER-a
  registration()
  {
    
    console.log(this.newUser)
    this.registrationService.registration(this.newUser)
    .subscribe();
  }

}
