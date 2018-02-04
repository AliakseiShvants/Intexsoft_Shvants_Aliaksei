import {Component, Injectable, OnInit} from '@angular/core';
import {LinkService} from "../../service/link.service";
import {Link} from "../../entity/link";

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})

@Injectable()
export class InfoComponent implements OnInit {
  private url: string;
  private postfix: string = 'info';
  private link: Link;

  constructor(private linkService: LinkService) {
  }

  ngOnInit() {}

  findLink(){
    if(this.url != ''){
      this.linkService.findByUrl(this.postfix, this.url)
        .subscribe(
          (res: Link) => this.link = res
        );
    }
  }

  set(link: Link){
    if (this.link.url.length > 10){
      this.linkService.setLink(this.link);
    }
  }
}
