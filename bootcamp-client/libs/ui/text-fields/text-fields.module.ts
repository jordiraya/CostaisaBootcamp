import { NgModule } from '@angular/core';
import { TextFieldInputDirective } from '@bcamp/ui/text-fields/src/directives/text-field-input.directive';
import { TextFieldComponent } from './src/components/text-field/text-field.component';

@NgModule({
  declarations: [
    TextFieldComponent,
    TextFieldInputDirective
  ],
  exports: [
    TextFieldComponent,
    TextFieldInputDirective
  ]
})
export class TextFieldsModule {

}
