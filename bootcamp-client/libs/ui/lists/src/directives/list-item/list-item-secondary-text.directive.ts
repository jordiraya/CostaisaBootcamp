import { Directive, OnInit } from '@angular/core';
import { TemplateRef } from '@angular/core';
import { HostBinding } from '@angular/core';
import { elementClass } from '@angular/core/src/render3/instructions';

@Directive({
  selector: '[bcamp-list-item-secondary-text], [bcampListItemSecondaryText]'
})

export class ListItemSecondaryTextDirective implements OnInit {
  @HostBinding('class') elementClass = '';
  constructor() {}

  ngOnInit() {
    this.elementClass = 'mdc-list-item__secondary-text';
  }
}
