import { Directive, OnInit } from '@angular/core';
import { TemplateRef } from '@angular/core';
import { HostBinding } from '@angular/core';
import { elementClass } from '@angular/core/src/render3/instructions';

@Directive({
  selector: '[bcamp-list-item-text], [bcampListItemText]'
})

export class ListItemTextDirective implements OnInit {
  @HostBinding('class') elementClass = '';
  constructor(/*public templateRef: TemplateRef<any>*/) {}

  ngOnInit() {
    this.elementClass = 'mdc-list-item__text';
  }
}
