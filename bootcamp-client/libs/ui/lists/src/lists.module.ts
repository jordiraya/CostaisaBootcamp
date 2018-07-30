import { ListItemSecondaryTextDirective } from './directives/list-item/list-item-secondary-text.directive';
import { ListItemTextDirective } from './directives/list-item/list-item-text.directive';
import { ListComponent } from './components/list/list.component';
import { NgModule } from '@angular/core';
import { ListItemDirective } from './directives/list-item/list-item.directive';
import { CommonModule } from '@angular/common';


@NgModule({
  imports: [CommonModule],
  declarations: [ListComponent, ListItemDirective, ListItemTextDirective, ListItemSecondaryTextDirective],
  exports: [ListComponent, ListItemDirective, ListItemTextDirective, ListItemSecondaryTextDirective]
})
export class ListsModule {}
