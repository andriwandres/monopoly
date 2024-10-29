import {CanActivateFn, Router} from '@angular/router';
import {Game, GameStatus} from '../shared/domain/game';
import {inject} from '@angular/core';

export const gameGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const roomId = route.paramMap.get('roomId')!;

  console.log('check if a game is available in localstorage');
  try {
    const game: Game = JSON.parse(localStorage.getItem('game')!);
    if (game.publicRoomId === roomId && game.status !== GameStatus.FINISHED) {
      console.log('player rejoins the game, load the game from backend');
      //maybe use a eventSequence to check if the game is up to date
      return true;
    }/* else {
      return false;
    }*/
  } catch (e) {
    console.log('no game available in localstorage, join the room');
  }
  // TODO join room
  router.navigate(['/'], { queryParams: { joinRoomId: roomId } });
  return  false;
};
