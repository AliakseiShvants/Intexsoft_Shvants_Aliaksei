import {Injectable, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {User} from "../entity/user";

@Injectable()
export class UserService implements OnInit{
  ngOnInit() {
  }

  address: string = 'api/users/';

  constructor(private httpClient: HttpClient){
  }

  postUser(user: User, postfix: string): Observable<any>{
    return this.httpClient.post(this.address.concat(postfix), user);
  }
}
