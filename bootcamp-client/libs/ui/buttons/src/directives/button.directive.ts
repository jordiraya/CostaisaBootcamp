import { elementClass } from '@angular/core/src/render3/instructions';
import { Directive, OnInit } from '@angular/core';
import { HostBinding } from '@angular/core';

@Directive({
  selector: 'button[bcamp-button], button[bcampButton]'
})
export class ButtonDirective implements OnInit {
  @HostBinding('class') elementClass = '';

  ngOnInit() {
    this.elementClass += ' mdc-button';
  }
}
