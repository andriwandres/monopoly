import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CreateRoomComponent } from './rooms/create-room/create-room.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CreateRoomComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {

}
