import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shorter',
  templateUrl: './shorter.component.html',
  styleUrls: ['./shorter.component.css']
})
export class ShorterComponent implements OnInit {
  url : string = "Новая ссылка:";
  description : string = "Пару слов о новой ссылке:";
  tags: string = "Тeги";
  
  constructor() { }

  ngOnInit() {
  }

}
