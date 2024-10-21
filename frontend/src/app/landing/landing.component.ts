import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RoomService } from '../shared/room.service';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css'
})
export class LandingComponent {
  private readonly roomService = inject(RoomService);

  readonly form = new FormGroup({
    nickname: new FormControl('')
  });

  createRoom(): void {
    this.roomService.createRoom();
  }
}
