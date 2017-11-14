import { Component, OnInit } from '@angular/core';
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";
import {Response} from "@angular/http";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User ;

  constructor(private userService : UserService) {
  }

  ngOnInit() {
    this.userService.getUser()
      .subscribe(
        (res: User) => this.user = res
      );
  }
}
