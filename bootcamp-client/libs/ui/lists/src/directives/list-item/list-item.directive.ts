import { ContentChild, Optional } from '@angular/core';
import { ListItemTextDirective } from './list-item-text.directive';
import { Directive } from '@angular/core';
import { TemplateRef } from '@angular/core';

@Directive({
  selector: '[bcamp-list-item], [bcampListItem]'
})

export class ListItemDirective {
  @ContentChild(ListItemTextDirective) itemText: ListItemTextDirective;
  constructor(@Optional() public templateRef: TemplateRef<any>) {}
}
