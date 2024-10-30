import { Component, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { GameService } from '../game/game.service';
import { ButtonComponent } from '../shared/button/button.component';
import { InputComponent } from '../shared/input/input.component';

@Component({
  selector: 'mon-landing',
  standalone: true,
  imports: [ButtonComponent, InputComponent, ReactiveFormsModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.scss',
})
export default class LandingComponent {
  private readonly gameService = inject(GameService);

  readonly nickname = new FormControl('');

  createGame(): void {
    this.gameService.createGame().subscribe((gameCode) => {
      this.gameService.navigateToGame(gameCode);
    });
  }
}
