import { TestBed, async } from '@angular/core/testing';
import { ListItemDirective } from '../../directives/list-item/list-item.directive';
import { Component } from '@angular/core';
import { ViewChild } from '@angular/core';
import { ListComponent } from './list.component';
import { ListsModule } from '../../lists.module';

describe('ListComponent', () => {
  beforeEach(async() => {
    TestBed.configureTestingModule({
      imports: [
        ListsModule
      ],
      declarations: [
        ListWithThreeItemsComponent]
    }).compileComponents();
  });

  it('should have 3 items', async(() => {
    const fixture = TestBed.createComponent(ListWithThreeItemsComponent);
    const listWithThreeItems = fixture.debugElement.componentInstance;
    expect(listWithThreeItems).toBeTruthy();
  }));

});

@Component({
  selector: 'bcamp-list-three-items',
  template: `
    <bcamp-list>
      <ng-container *bcampListItem>
        <span bcampListItemText>
          Hola
        </span>
      </ng-container>
    </bcamp-list>
  `
})
export class ListWithThreeItemsComponent {

  @ViewChild(ListComponent) list: ListComponent;
}
