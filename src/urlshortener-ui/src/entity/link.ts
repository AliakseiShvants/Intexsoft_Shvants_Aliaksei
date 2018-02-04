export class Link{

  linkId: number;
  url: string;
  shortUrl: string;
  tags: any;
  description: string;


  // constructor() {
  // }

// constructor(url: string) {
  //   this.url = url;
  // }

constructor(/*linkId: number,*/ url: string, shortUrl: string, description: string) {
    // this.linkId = linkId;
    this.url = url;
    this.shortUrl = shortUrl;
    this.description = description;
  }


}
