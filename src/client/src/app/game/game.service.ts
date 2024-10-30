import { inject, Injectable } from '@angular/core';
import { GameServer } from './game-server.service';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class GameService {
  private readonly socketService = inject(GameServer);
  private readonly httpClient = inject(HttpClient);

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
