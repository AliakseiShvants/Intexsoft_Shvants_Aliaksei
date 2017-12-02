export class Link{
  linkId: number;
  url: string;
  shortUrl: string;
  description: string;

  constructor(url: string) {
    this.url = url;

  }
}
