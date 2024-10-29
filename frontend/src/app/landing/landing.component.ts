import {Component, inject, OnInit} from '@angular/core';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {RoomService} from '../shared/room.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css',
})
export class LandingComponent implements OnInit {
  private readonly roomService = inject(RoomService);

  readonly nickname = new FormControl('')

  roomId: string = "";

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.roomId = params['joinRoomId'];
    });
  }

  createOrJoinRoom(): void {
    if (this.roomId) {
      this.roomService.joinRoom(this.roomId, this.nickname.value!);
      return;
    }
    this.roomService.createRoom(this.nickname.value!);
  }
}
