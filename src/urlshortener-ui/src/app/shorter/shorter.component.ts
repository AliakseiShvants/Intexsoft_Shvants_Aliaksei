import {Component, Injectable, OnInit} from '@angular/core';
import {Link} from "../../entity/link";
import {LinkService} from "../../service/link.service";

@Component({
  selector: 'app-shorter',
  templateUrl: './shorter.component.html',
  styleUrls: ['./shorter.component.css']
})

@Injectable()
export class ShorterComponent implements OnInit {
  private postfix = 'link/shorter';
  private findPostfix = 'link/find';

  link: Link;
  linkId: number;
  url: string;
  description: string;

  isPresent = false;
  preview = false;

  constructor(private linkService: LinkService) { }

  // check(){
  //   if(this.url != '' ){
  //     this.linkService.postUrl(this.findPostfix, this.url)
  //       .subscribe(
  //         (data: Link) => this.linkId = data,
  //         error => {
  //           console.log(error)
  //         }
  //       );
  //   }
  //   else alert("Нечего сокращать!");
  // }

   post(){
     if(this.url != '' ){
       this.linkService.postLink(this.postfix, new Link(this.url, "", this.description))
         .subscribe(
           (data: Link) => this.link = data,
           error => {
             console.log(error)
           }
         );
       // if(this.link == null){
       //   this.isPresent = true;
       // }
     }
     else alert("Нечего сокращать!");
     // this.isPresent = true;
   }

   set(){
    this.preview = true;

   }

   ngOnInit(){}
}
