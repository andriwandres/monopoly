import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ConnectivityService } from './connectivity.service';

const URL_PREFIX = 'http://localhost:8000/game';

@Injectable({ providedIn: 'root' })
export class RoomService {
  private readonly router = inject(Router);
  private readonly connectivityService = inject(ConnectivityService);
  private readonly http = inject(HttpClient);

  createRoom(nickname: string): void {
    const payload = { nickname };

    this.http
      .post<string>(`${URL_PREFIX}/start`, payload)
      .subscribe(roomId => this.joinRoom(roomId, nickname));
  }

  private joinRoom(roomId: string, nickname: string): void {
    this.connectivityService.send('/app/joinGame', {
      roomId,
      nickname
    });

    this.router.navigate(['room', `${roomId}`]);
  }
}
