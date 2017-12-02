import {Injectable, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Link} from "../entity/link";

@Injectable()
export class LinkService implements OnInit{



  private link: Link = new Link('');
  address: string = 'api/links/link/';

  ngOnInit() {
  }

  constructor(private httpClient: HttpClient) {
  }


  setLink(link: Link){
    this.link = link;
  }

  getLink(): Link{
    return this.link;
  }

  findByUrl(postfix: string, link: Link){
    return this.httpClient.post(this.address.concat(postfix), link);
  }
}
