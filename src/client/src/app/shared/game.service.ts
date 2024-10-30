import { inject, Injectable } from '@angular/core';
import { SocketService } from './socket.service';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class GameService {
  private readonly socketService = inject(SocketService);
  private readonly httpClient = inject(HttpClient);

  constructor() {
    this.createGame().subscribe((gameCode) => {
      this.socketService.connect(gameCode, 'playerOne', 'affe69').then(() => {
        this.socketService.on('TurnEnded').subscribe(() => {
          console.log('turn ended');
        });

        this.socketService.on<any>('DiceThrown').subscribe((dice) => {
          console.log('dice thrown ', dice);
        });
      });
    });
  }

  createGame(): Observable<string> {
    return this.httpClient.post<string>(`${environment.serverUrl}/game`, {});
  }

  endTurn(): void {
    this.socketService.send('EndTurn');
  }

  throwDice(): void {
    this.socketService.send('ThrowDice');
  }
}
