import { Component, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RoomService } from '../shared/room.service';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css',
})
export class LandingComponent {
  private readonly roomService = inject(RoomService);

  readonly nickname = new FormControl('')

  createRoom(): void {
    this.roomService.createRoom(this.nickname.value!);
  }
}
