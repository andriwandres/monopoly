import { Component } from '@angular/core';

@Component({
  selector: 'app-dice',
  standalone: true,
  imports: [],
  templateUrl: './dice.component.html',
  styleUrl: './dice.component.css'
})
export class DiceComponent {
  dice: [number, number] | undefined;

  throwDice(): void {
    // throw dice
    this.dice = [1, 1];
  }
}
