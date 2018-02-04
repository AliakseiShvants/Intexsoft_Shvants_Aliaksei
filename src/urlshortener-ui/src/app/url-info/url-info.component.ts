import {Component, Injectable, OnInit} from '@angular/core';
import {LinkService} from "../../service/link.service";
import {Link} from "../../entity/link";
import {Input} from '@angular/core';

@Component({
  selector: 'app-url-info',
  templateUrl: './url-info.component.html',
  styleUrls: ['./url-info.component.css']
})

@Injectable()
export class UrlInfoComponent implements OnInit {

  private link: Link ;
  constructor(private linkService: LinkService) {
    /*this.link = this.linkService.getLink();*/
  }

  ngOnInit() {

  }

}
