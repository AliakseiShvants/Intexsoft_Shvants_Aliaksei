import { Component, OnInit } from '@angular/core';
import {LinkService} from "../../service/link.service";
import {Link} from "../../entity/link";
import {and} from "@angular/router/src/utils/collection";


@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {


  url: string;
  postfix: string = 'info';
  link: Link = new Link('');
  isFail = false;

  constructor(private linkService: LinkService) {
  }

  ngOnInit() {}

  findLink(){
    if(this.url != ''){
      this.linkService.findByUrl(this.postfix, new Link(this.url))
        .subscribe(
          (res: Link) => this.link = res,
          error2 => console.log(error2)
        );
    }
    if(this.link.url != null){
      this.linkService.setLink(this.link);
    } else {
      this.isFail = true;
    }
  }
}
