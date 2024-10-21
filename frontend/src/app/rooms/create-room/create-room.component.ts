import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-room',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './create-room.component.html',
  styleUrl: './create-room.component.css'
})
export class CreateRoomComponent {
  readonly form = new FormGroup({
    nickname: new FormControl('')
  });

  submit(): void {

  }
}
