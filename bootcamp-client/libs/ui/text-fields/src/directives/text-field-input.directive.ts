import { Directive, HostBinding } from '@angular/core';
import { OnInit } from '@angular/core';

@Directive({
  selector: 'input[bcamp-text-field-input], input[bcampTextFieldInput]'
})

export class TextFieldInputDirective implements OnInit {

  @HostBinding('class') elementClass = '';

  ngOnInit() {
    this.elementClass += 'mdc-text-field__input';
  }

}
