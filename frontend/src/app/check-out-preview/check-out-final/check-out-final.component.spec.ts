import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckOutFinalComponent } from './check-out-final.component';

describe('CheckOutFinalComponent', () => {
  let component: CheckOutFinalComponent;
  let fixture: ComponentFixture<CheckOutFinalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckOutFinalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckOutFinalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
