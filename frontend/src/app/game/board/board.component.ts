import { Component, inject } from '@angular/core';
import { PropertyTile } from '../../shared/domain/tile';
import { BoardService } from './board.service';
import { PropertyTileComponent } from './property-tile/property-tile.component';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [PropertyTileComponent],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent {
  readonly board: PropertyTile[];

  constructor() {
    this.board = inject(BoardService).getBoard();
  }
}
