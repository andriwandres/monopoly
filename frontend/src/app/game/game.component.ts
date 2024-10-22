import { Component } from '@angular/core';
import { RoomInformationComponent } from './room-information/room-information.component';
import { BoardComponent } from './board/board.component';

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [RoomInformationComponent, BoardComponent],
  templateUrl: './game.component.html',
  styleUrl: './game.component.css'
})
export class GameComponent {

}
