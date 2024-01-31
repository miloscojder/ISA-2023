import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegUserDashboardComponent } from './reg-user-dashboard.component';

describe('RegUserDashboardComponent', () => {
  let component: RegUserDashboardComponent;
  let fixture: ComponentFixture<RegUserDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegUserDashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegUserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
