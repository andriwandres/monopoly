import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RoomService } from '../../shared/room.service';

@Component({
  selector: 'app-create-room',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './create-room.component.html',
  styleUrl: './create-room.component.css'
})
export class CreateRoomComponent {
  private readonly roomService = inject(RoomService);

  readonly form = new FormGroup({
    nickname: new FormControl('')
  });

  createRoom(): void {
    this.roomService.createRoom();
  }
}
