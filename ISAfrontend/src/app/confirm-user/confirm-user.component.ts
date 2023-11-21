import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-confirm-user',
  templateUrl: './confirm-user.component.html',
  styleUrls: ['./confirm-user.component.css']
})
export class ConfirmUserComponent implements OnInit {
  id:number;
  user: User;
  constructor(private userService : UserService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  activateAccount(){
    this.id = this.route.snapshot.params['id'];
    this.userService.activateById(this.id)
    .subscribe();
    this.router.navigate(['login']);
  }

}
