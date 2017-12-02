import {Component, OnInit} from '@angular/core';
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user : User = new User('','','');
  confirmPassword : string;
  success = false;
  notExist = false;
  postfix: string = 'register';

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  submit(user: User){
    if(user.fullName != '' && user.login != '' && user.password != ''){
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
