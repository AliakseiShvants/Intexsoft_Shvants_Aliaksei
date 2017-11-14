import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnMainComponent } from './on-main.component';

describe('OnMainComponent', () => {
  let component: OnMainComponent;
  let fixture: ComponentFixture<OnMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
