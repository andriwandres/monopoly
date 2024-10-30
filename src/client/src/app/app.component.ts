import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { GameService } from './shared/game.service';

@Component({
  standalone: true,
  imports: [RouterModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  private readonly gameService = inject(GameService);

  endTurn() {
    this.gameService.endTurn();
  }

  throwDice() {
    this.gameService.throwDice();
  }
}
