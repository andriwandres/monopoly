import { Component, input, output } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ButtonComponent } from '../button/button.component';
import { InputComponent } from '../input/input.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';

export interface Player {
  nickname: string;
  colorHex: string;
}

@Component({
  selector: 'mon-player-form',
  standalone: true,
  imports: [
    ButtonComponent,
    InputComponent,
    ReactiveFormsModule,
    FormsModule,
    ColorPickerComponent,
  ],
  templateUrl: './player-form.component.html',
  styleUrl: './player-form.component.scss',
})
export class PlayerFormComponent {
  readonly submitText = input.required<string>();
  readonly submit = output<Player>();

  protected readonly form = new FormGroup({
    nickname: new FormControl('', [Validators.required]),
    colorHex: new FormControl('', [Validators.required]),
  });

  onSubmit(): void {
    this.submit.emit(this.form.value as Player);
  }
}
