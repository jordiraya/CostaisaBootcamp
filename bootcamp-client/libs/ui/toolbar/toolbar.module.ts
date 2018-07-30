import { NgModule } from '@angular/core';
import { ToolbarComponent } from './components/toolbar.components';
import { ToolbarRowDirective } from './directives/toolbar-row.directive';
import { ToolbarSectionDirective } from './directives/toolbar-section.directive';
import { ToolbarTitleDirective } from './directives/toolbar-title.directive';

@NgModule({
  declarations: [ToolbarComponent, ToolbarRowDirective, ToolbarSectionDirective, ToolbarTitleDirective],
  exports: [ToolbarComponent, ToolbarRowDirective, ToolbarSectionDirective, ToolbarTitleDirective]
})
export class ToolbarModule {}
