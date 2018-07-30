import { Directive, HostBinding, OnInit } from '@angular/core';

@Directive({
  selector: '[bcamp-toolbar-section], [bcampToolbarSection]'
})
export class ToolbarSectionDirective implements OnInit {
  @HostBinding('class') elementClass = '';

  ngOnInit() {
     this.elementClass = 'mdc-top-app-bar__section';
  }
}
