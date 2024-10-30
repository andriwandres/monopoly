import { Route } from '@angular/router';

export const appRoutes: Route[] = [
  {
    path: '',
    pathMatch: 'full',
    loadComponent: () => import('./landing/landing.component'),
  },
  {
    path: 'game/:gameCode',
    loadComponent: () => import('./game/game.component'),
  },
];
