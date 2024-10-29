import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ConnectivityService } from './connectivity.service';
import {Player} from './domain/player';
import {Game} from './domain/game';

const URL_PREFIX = 'http://localhost:8080/game';

export interface InitialGameDto {
  publicRoomId: string;
}

@Injectable({ providedIn: 'root' })
export class RoomService {
  private readonly router = inject(Router);
  private readonly connectivityService = inject(ConnectivityService);
  private readonly http = inject(HttpClient);

  createRoom(nickname: string): void {
    this.http
      .post<InitialGameDto>(`${URL_PREFIX}/start`, null)
      .subscribe(({ publicRoomId}) => this.joinRoom(publicRoomId, nickname));
  }

  joinRoom(roomId: string, nickname: string): void {
    this.connectivityService.send('/app/join', {
      roomId,
      nickName: nickname,
      hexColor: '#AFFE69' // TODO determine
    });

    // TODO remove eventually
    this.connectivityService.on(`/topic/game/${roomId}`, (m: Game) => {
      localStorage.setItem('game', JSON.stringify(m));
      console.log('game state', m);
      this.router.navigate(['room', `${roomId}`]);
    });

    // Receive player information
    this.connectivityService.on(`/topic/game/${roomId}/${nickname}`, m => {
      localStorage.setItem('player', JSON.stringify(m));
      console.log('player', m);
    });
  }

  sendChatMessage(roomId: string, message: string): void {
    const player: Player = JSON.parse(localStorage.getItem('player')!);

    this.connectivityService.send(`/app/chat`, {
      roomId,
      playerId: player.gamePlayerId,
      message
    });
  }
}
