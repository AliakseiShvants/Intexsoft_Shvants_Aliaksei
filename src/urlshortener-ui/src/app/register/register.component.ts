import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";
import {errorObject} from "rxjs/util/errorObject";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user : User = new User('','','','');
  success: boolean = true;

  @ViewChild('successBlock')
  successBlock: TemplateRef<any>|null = null;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  submit(user: User){
    this.userService.register(user)
      .subscribe(
        (flag: boolean) => this.success = flag,
        error => console.log(error)
        );
  }

  // successMessage(){
  //   alert("Новый пользователь успешно добавлен!");
  // }
  // faultMessage(){
  //   alert("Пользователь с таким именем или логином уже существует!");
  // }
}
