import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TextFieldsModule } from './../../../../libs/ui/text-fields/text-fields.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { AppComponent } from './app.component';
import { ToolbarModule } from '@bcamp/ui/toolbar';
import { ListsModule } from '@bcamp/ui/lists';
import { PersonalDiaryModule } from '@bcamp/personal-diary';
import { ButtonsModule } from '@bcamp/ui/buttons';

export function httpLoader(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        deps: [HttpClient],
        useFactory: httpLoader
      }
    }),
    ToolbarModule,
    ListsModule,
    ButtonsModule,
    TextFieldsModule,
    PersonalDiaryModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
