import { inject, Injectable } from '@angular/core';
import { ConnectivityService } from '../../../shared/connectivity.service';
import { diceThrownTopic } from '../../../shared/topics';

export interface DiceThrownEvent {
  die1: number;
  die2: number;
}

@Injectable({ providedIn: 'root' })
export class DiceService {
  private readonly connectivityService = inject(ConnectivityService);

  throwDice(): void {
    this.connectivityService.on<DiceThrownEvent>(diceThrownTopic(), (message) => {
      console.log(message);
    });
  }
}
