import { Component, input } from '@angular/core';
import { PropertyTile } from '../../../shared/domain/tile';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-property-tile',
  standalone: true,
  imports: [CurrencyPipe],
  templateUrl: './property-tile.component.html',
  styleUrl: './property-tile.component.css',
})
export class PropertyTileComponent {
  readonly property = input.required<PropertyTile>();
}
