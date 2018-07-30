import { Directive, HostBinding, OnInit } from '@angular/core';

@Directive({
  selector: '[bcamp-toolbar-row], [bcampToolbarRow]'
})
export class ToolbarRowDirective implements OnInit {
  @HostBinding('class') elementClass = '';

  ngOnInit() {
     this.elementClass = 'mdc-top-app-bar__row';
  }
}
