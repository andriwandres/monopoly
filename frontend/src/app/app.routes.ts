import { Routes } from '@angular/router';
import { gameGuard } from './game/game.guard';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadComponent: () => import('./landing/landing.component').then(c => c.LandingComponent)
  },
  {
    path: 'room/:roomId',
    loadComponent: () => import('./game/game.component').then(c => c.GameComponent),
    canActivate: [gameGuard]
  },
];
