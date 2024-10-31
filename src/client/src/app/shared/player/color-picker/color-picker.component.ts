import { Component, forwardRef } from '@angular/core';
import {
  ControlValueAccessor,
  NG_VALUE_ACCESSOR,
  ReactiveFormsModule,
} from '@angular/forms';

const allColors = ['red', 'green', 'blue', 'orange'];

@Component({
  selector: 'mon-color-picker',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './color-picker.component.html',
  styleUrl: './color-picker.component.scss',
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      multi: true,
      useExisting: forwardRef(() => ColorPickerComponent),
    },
  ],
})
export class ColorPickerComponent implements ControlValueAccessor {
  protected readonly colors = allColors;
  protected selectedColor: string | undefined;

  private touched = false;

  private onChangeFn: (_: string) => unknown = () => undefined;
  private onTouchedFn: () => unknown = () => undefined;

  writeValue(color: string): void {
    this.selectedColor = color;
  }

  registerOnChange(onChangeFn: (_: string) => unknown): void {
    this.onChangeFn = onChangeFn;
  }

  registerOnTouched(onTouchedFn: () => unknown): void {
    this.onTouchedFn = onTouchedFn;
  }

  selectColor(color: string) {
    this.writeValue(color);
    this.onChangeFn(color);

    if (!this.touched) {
      this.touched = true;
      this.onTouchedFn();
    }
  }
}
