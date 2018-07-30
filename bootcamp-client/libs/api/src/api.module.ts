import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { ApiService } from './providers/api.service';
import { API_PREFIX } from './providers/api-prefix.token';
import { LoginInterceptor } from './providers/login.interceptor';

@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LoginInterceptor,
      multi: true
    },
    {
      provide: ApiService,
      deps: [API_PREFIX, HttpClient], // params del constructor para la inyección, API_PREFIX es InjectionToken
      useFactory: apiServiceFactory
    }
  ]
})
export class ApiModule {}

export function apiServiceFactory(urlPrefix: string, httpClient: HttpClient) {
  return new ApiService(urlPrefix, httpClient);
}
