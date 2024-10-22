import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';

const ROOM_IDENTIFIER_LENGTH = 10;

@Injectable({ providedIn: 'root' })
export class RoomService {
  private readonly router = inject(Router);

  createRoom(nickname: string): void {
    const roomIdentifier = this.generateRoomIdentifier();

    // TODO generate room & join as admin player

    this.router.navigate(['room', `${roomIdentifier}`]);
  }

  private generateRoomIdentifier(): string {
    const characters = 'abcdefghijklmnopqrstuvwxyz1234567890';

    let identifier = '';

    for (let index = 0; index < ROOM_IDENTIFIER_LENGTH; index++) {
      identifier += characters.charAt(Math.floor(Math.random() * characters.length));
    }

    return identifier;
  }
}
