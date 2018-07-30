import { Directive, HostBinding, OnInit } from '@angular/core';

@Directive({
  selector: '[bcamp-toolbar-title], [bcampToolbarTitle]'
})
export class ToolbarTitleDirective implements OnInit {
  @HostBinding('class') elementClass = '';

  ngOnInit() {
     this.elementClass = 'mdc-top-app-bar__title';
  }
}
