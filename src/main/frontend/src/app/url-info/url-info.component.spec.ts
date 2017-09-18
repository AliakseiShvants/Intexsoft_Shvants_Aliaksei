import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UrlInfoComponent } from './url-info.component';

describe('UrlInfoComponent', () => {
  let component: UrlInfoComponent;
  let fixture: ComponentFixture<UrlInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UrlInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UrlInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
