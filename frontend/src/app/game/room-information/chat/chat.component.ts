import {Component, inject} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {RoomService} from '../../../shared/room.service';
import {ConnectivityService} from '../../../shared/connectivity.service';
import {ChatMessage} from '../../../shared/domain/chatMessage';

@Component({
  selector: 'app-chat',
  template: `
    <div class="chat-container">
      <div class="message-list" >
        @for (message of messages; track message) {
          <div class="message">
            <strong>{{ message }}</strong>
          </div>
        }
      </div>
      <div class="input-container">
        <input [(ngModel)]="newMessage" placeholder="Type a message..." (keyup.enter)="sendMessage()">
        <button (click)="sendMessage()">Send</button>
      </div>
    </div>
  `,
  standalone: true,
  imports: [
    FormsModule
  ],
  styles: [`
    .chat-container {
      display: flex;
      flex-direction: column;
      height: 400px;
      border: 1px solid #ccc;
      border-radius: 4px;
      max-width: 400px;
    }

    .message-list {
      flex: 1;
      overflow-y: auto;
      padding: 10px;
      height: 100px;
      display: flex;
      flex-direction: column-reverse;
    }

    .message {
      margin-bottom: 10px;
      color: white;
    }

    .input-container {
      display: flex;
      padding: 10px;
    }

    input {
      flex: 1;
      margin-right: 10px;
    }
  `]
})
export class ChatComponent {
  private readonly roomService = inject(RoomService);
  private readonly connectivityService = inject(ConnectivityService);

  private readonly roomId: string;
  messages: string[] = [];
  newMessage = '';

  constructor() {
    this.roomId = window.location.pathname.split('/').pop()!;
    this.connectivityService.on(`/topic/game/${this.roomId}/event/messageSent`, (m: ChatMessage) => {
      this.messages.unshift(`${m.fromPlayerName}: ${m.text}`);
    });
  }

  sendMessage() {
    if (this.newMessage !== '') {
      this.roomService.sendChatMessage(this.roomId, this.newMessage);
      this.newMessage = '';
    }
  }
}
