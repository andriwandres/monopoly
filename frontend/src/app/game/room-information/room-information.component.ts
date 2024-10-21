import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-room-information',
  standalone: true,
  imports: [],
  templateUrl: './room-information.component.html',
  styleUrl: './room-information.component.css'
})
export class RoomInformationComponent {
  private readonly activatedRoute = inject(ActivatedRoute);
  private readonly router = inject(Router);
  private readonly location = inject(Location);

  readonly shareLink!: string;

  constructor() {
    this.shareLink = this.createShareLink();
  }

  private createShareLink(): string {
    const roomId = this.activatedRoute.snapshot.paramMap.get('roomId')!

    const resource = this.router.createUrlTree(['room', roomId]);
    const host = window.location.href.replace(this.location.path(), '');

    return `${host}${resource}`;
  }
}
