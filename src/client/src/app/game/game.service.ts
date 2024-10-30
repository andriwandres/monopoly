import { inject, Injectable } from '@angular/core';
import { GameServer } from './game-server.service';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class GameService {
  private readonly socketService = inject(GameServer);
  private readonly httpClient = inject(HttpClient);
  private readonly router = inject(Router);

  createGame(): Observable<string> {
    return this.httpClient.post<string>(`${environment.serverUrl}/game`, {});
  }

  navigateToGame(gameCode: string): void {
    this.router.navigate(['game', gameCode]);
  }
}
