import { Component, ContentChildren, QueryList } from '@angular/core';
import { ListItemDirective } from '../../directives/list-item/list-item.directive';

@Component({
  selector: 'bcamp-list',
  templateUrl: 'list.component.html'
})
export class ListComponent {
  @ContentChildren(ListItemDirective) items: QueryList<ListItemDirective>;

}
