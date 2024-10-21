import { Routes } from '@angular/router';
import { CreateRoomComponent } from './rooms/create-room/create-room.component';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: CreateRoomComponent
  },
  {
    path: 'room/:roomId',
    loadComponent: () => import('./game/game.component').then(c => c.GameComponent)
  },
];
