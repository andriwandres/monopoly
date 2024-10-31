import { Component, inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import { GameService } from '../game/game.service';
import {
  Player,
  PlayerFormComponent,
} from '../shared/player/player-form.component';

@Component({
  selector: 'mon-landing',
  standalone: true,
  imports: [PlayerFormComponent],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.scss',
})
export default class LandingComponent {
  private readonly gameService = inject(GameService);

  protected readonly nickname = new FormControl('');

  createGame(player: Player): void {
    console.log(player);

    this.gameService.createGame().subscribe((gameCode) => {
      this.gameService.navigateToGame(gameCode);
    });
  }
}
