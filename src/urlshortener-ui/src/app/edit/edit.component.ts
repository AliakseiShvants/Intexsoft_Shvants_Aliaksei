import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  url : string = "Править ссылку:";
  description : string = "Править описание ссылки:";
  tags: string = "Править тeги";

  constructor() { }

  ngOnInit() {
  }

}
