import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckOutPreviewComponent } from './check-out-preview.component';

describe('CheckOutPreviewComponent', () => {
  let component: CheckOutPreviewComponent;
  let fixture: ComponentFixture<CheckOutPreviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckOutPreviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckOutPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
