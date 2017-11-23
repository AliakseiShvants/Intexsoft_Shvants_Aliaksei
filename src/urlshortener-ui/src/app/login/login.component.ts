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
  user : User = new User('','','');
  success = false;
  notExist = false;

  constructor(private userService : UserService) {
  }
  ngOnInit() {}

  submit(user: User){
    if(user.login != '' && user.password != ''){
      this.userService.register(user)
        .subscribe(
          (data: boolean) => this.success = data,
          error => {
            console.log(error)
          }
        );
      if(!this.success){
        this.notExist = true;
      }
    }
    else alert("Данные для регистрации введены неверно");
  }
}
