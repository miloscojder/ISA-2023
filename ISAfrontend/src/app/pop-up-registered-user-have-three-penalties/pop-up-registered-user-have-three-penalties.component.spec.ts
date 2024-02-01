import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpRegisteredUserHaveThreePenaltiesComponent } from './pop-up-registered-user-have-three-penalties.component';

describe('PopUpRegisteredUserHaveThreePenaltiesComponent', () => {
  let component: PopUpRegisteredUserHaveThreePenaltiesComponent;
  let fixture: ComponentFixture<PopUpRegisteredUserHaveThreePenaltiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpRegisteredUserHaveThreePenaltiesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpRegisteredUserHaveThreePenaltiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
