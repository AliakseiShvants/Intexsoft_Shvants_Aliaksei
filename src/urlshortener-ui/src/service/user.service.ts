import {Injectable, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {User} from "../entity/user";

@Injectable()
export class UserService implements OnInit{
  ngOnInit() {
  }

  private headers = new Headers({'Content-Type': 'text'});

  url: string = 'api/users/getMockUser';
  registerUrl: string = 'api/users/register';

  constructor(private httpClient: HttpClient){
  }

  getUser(): Observable<any>{
    return this.httpClient.get(this.url);
  }

  register(user: User): Observable<any>{
    return this.httpClient.post(this.registerUrl, user);
  }


}
