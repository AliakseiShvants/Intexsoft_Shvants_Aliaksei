import { Component, OnInit } from '@angular/core';
import {Link} from "../../entity/link";
import {LinkService} from "../../service/link.service";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  postfix = "all";
  links: Link[];

  constructor(private linkService: LinkService) {

    this.linkService.findAll(this.postfix)
      .subscribe(
        (data: Link[]) => this.links = data,
        error2 => console.log(error2)
      );
  }

  ngOnInit() {

  }

}
