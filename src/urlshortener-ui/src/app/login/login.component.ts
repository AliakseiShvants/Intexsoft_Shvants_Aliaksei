import {Component, OnInit} from '@angular/core';
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user : User = new User('','','');
  success = false;
  notExist = false;

  postfix: string = 'login';

  constructor(private userService : UserService) {
  }
  ngOnInit() {}

  submit(user: User){
    if(user.login != '' && user.password != ''){
      this.userService.postUser(user, this.postfix)
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
