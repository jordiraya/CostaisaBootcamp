import { ToolbarModule } from '@bcamp/ui/toolbar';
import { ButtonsModule } from '@bcamp/ui/buttons';
import { TextFieldsModule } from '@bcamp/ui/text-fields/text-fields.module';
import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { PersonalDiaryModule } from '@bcamp/personal-diary';
import { ListsModule } from '@bcamp/ui/lists';
import { BrowserModule } from '@angular/platform-browser';

describe('AppComponent', () => {

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [
        BrowserModule,
        ToolbarModule,
        ListsModule,
        ButtonsModule,
        TextFieldsModule,
        PersonalDiaryModule
      ]
    }).compileComponents();
  }));
  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
  it(`should have as title 'app'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('app');
  }));
});
