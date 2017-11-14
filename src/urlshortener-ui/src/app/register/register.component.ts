import { Component, OnInit } from '@angular/core';
import {User} from "../../entity/user";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  fullName: string;
  login: string;
  password: string;
  newUser : User;

  constructor() { }

    ngOnInit() {
  }

}
