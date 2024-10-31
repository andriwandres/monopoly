import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class GameService {
  private readonly httpClient = inject(HttpClient);
  private readonly router = inject(Router);

  createGame(): Observable<string> {
    return this.httpClient.post<string>(`${environment.serverUrl}/game`, {});
  }

  navigateToGame(gameCode: string): void {
    this.router.navigate(['game', gameCode]);
  }
}
