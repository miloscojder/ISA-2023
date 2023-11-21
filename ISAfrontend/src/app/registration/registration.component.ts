import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { RegistrationService } from '../service/registration.service';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  mustfill:string;
  mustfillp:string;
  differentPasswords = false;
  newUser:User;
  users:User[];
  password1:string;
  registrated: boolean = true;


  constructor(private registrationService:RegistrationService, private router: Router, private userService: UserService) 
  {
      this.newUser = new User
      (
        {
          id: 9,
          firstName:"",
          lastName: "",
          email: "",
          username:"",
          password:"",
          mobile:"",
          city:"",
          state:"",
          sex:"",
          profession:"",
          organizationInformation:"",
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
    if(this.newUser.lastName==''){
      this.mustfill="required";
    }
    else if(this.newUser.firstName==''){
      this.mustfill="required";
    }
    else if(this.newUser.email==''){
      this.mustfill="required";
    }
    else if(this.newUser.mobile==''){
      this.mustfill="required";
    }
    else if(this.newUser.city==''){
      this.mustfill="required";
    }
    else if(this.newUser.state==''){
      this.mustfill="required";
    }
    else if(this.newUser.profession==''){
      this.mustfill="required";
    }
    else if(this.newUser.organizationInformation==''){
      this.mustfill="required";
    }
    else if(this.newUser.password!=this.password1){
      this.differentPasswords=true;
    }
    else{
    console.log(this.newUser)
    this.newUser.role='RegisteredUser'
    this.newUser.username=this.newUser.email;
    
    /*Obicna registracija - bez slanja maila
    this.registrationService.registration(this.newUser)
    .subscribe();*/
    //Slanje emaila za registraciju
    this.userService.sendEmail(this.newUser)
    .subscribe();
    this.registrated = false;

    } 

  }

}
