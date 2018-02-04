import {Injectable, Input, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Link} from "../entity/link";

@Injectable()
export class LinkService implements OnInit{

  private link: Link ;
  @Input()
  private linkId;
  private address: string = 'api/links/';

  url: string;
  ngOnInit() {
  }

  constructor(private httpClient: HttpClient) {
  }

  setLinkId(id: number){
    this.linkId = id;
  }

  getLinkId(): number{
    return this.linkId;
  }

   /*setLink(linkId: number, urll: string, shortUrl: string, description: string){
    this.link.linkId = linkId;
    this.url = urll;
    this.link.shortUrl = shortUrl;
    this.link.description = description;
  }*/

  setLink(lnk: Link){
    this.link = lnk;
  }

  getLink(): Link{
    return this.link;
  }

  findByUrl(postfix: string, url: string){
    return this.httpClient.post(this.address.concat(postfix), url);
  }

  postLink(postfix: string, link: Link){
    return this.httpClient.post(this.address.concat(postfix), link);
  }

  postUrl(postfix: string, url: string){
    return this.httpClient.post(this.address.concat(postfix), url);
  }

  findAll(postfix: string){
    return this.httpClient.get(this.address.concat(postfix))
  }
}
