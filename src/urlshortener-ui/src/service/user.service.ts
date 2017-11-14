import {Injectable, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UserService implements OnInit{
  ngOnInit() {
  }

  url:string = 'api/users/getMockUser';

  constructor(private httpClient: HttpClient){
  }

  getUser(): Observable<any>{
    return this.httpClient.get(this.url);
  }
}
