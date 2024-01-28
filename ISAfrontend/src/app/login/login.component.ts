import { Component,EventEmitter, OnInit ,  Output} from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newUser:User;
  username: any;
  password = '';
  invalidLogin = false;
  error:string='';
  idLoginUser:any;
  loggedUser: Boolean;
  @Output()
  LogIn: EventEmitter<void> = new EventEmitter();
  constructor(private router: Router,
    private loginservice: AuthenticationService) { 

  }

  ngOnInit(): void {
  }

 
  login() {
    if (this.username == '' || this.password == '')
      this.error = "Username and password must be filled out";
    else {
      this.loginservice.authenticate(this.username, this.password).subscribe(
        (data: any) => {
          console.log(data)
          this.LogIn.next();
          this.idLoginUser = sessionStorage.getItem('id');
          this.router.navigate(['home-page']);
          this.invalidLogin = false
        },
        (error: { message: string | null; }) => {
          this.invalidLogin = true
          this.error = "Invalid username or password or your account is not active";

        })
    }
  }

}
