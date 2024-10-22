import { CanActivateFn } from '@angular/router';

export const gameGuard: CanActivateFn = (route, state) => {
  const roomId = route.paramMap.get('roomId')!;

  // TODO join room

  return true;
};
