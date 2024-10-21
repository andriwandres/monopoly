import { Component } from '@angular/core';
import { RoomInformationComponent } from './room-information/room-information.component';

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [RoomInformationComponent],
  templateUrl: './game.component.html',
  styleUrl: './game.component.css'
})
export class GameComponent {

}
