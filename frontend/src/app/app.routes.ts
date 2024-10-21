import { Routes } from '@angular/router';
import { CreateRoomComponent } from './rooms/create-room/create-room.component';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: CreateRoomComponent
  },
  {
    path: ':roomId',
    loadComponent: () => import('./board/board.component').then(c => c.BoardComponent)
  },
];
