import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShorterComponent } from './shorter.component';

describe('ShorterComponent', () => {
  let component: ShorterComponent;
  let fixture: ComponentFixture<ShorterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShorterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShorterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
