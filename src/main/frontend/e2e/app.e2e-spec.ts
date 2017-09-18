import { UrlsshortenerAppPage } from './app.po';

describe('urlsshortener-app App', function() {
  let page: UrlsshortenerAppPage;

  beforeEach(() => {
    page = new UrlsshortenerAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
