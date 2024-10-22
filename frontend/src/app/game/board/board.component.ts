import { Component, inject } from '@angular/core';
import { Board } from '../../shared/domain/board';
import { BoardService } from './board.service';
import { DiceComponent } from './dice/dice.component';
import { PropertyTileComponent } from './property-tile/property-tile.component';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [PropertyTileComponent, DiceComponent],
  templateUrl: './board.component.html',
  styleUrl: './board.component.scss'
})
export class BoardComponent {
  readonly board: Board;

  constructor() {
    this.board = inject(BoardService).getBoard();
    console.log(this.board);
  }
}
