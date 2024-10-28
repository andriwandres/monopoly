import { Injectable, OnDestroy } from '@angular/core';
import { Client, IStompSocket } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

const SOCKET_URL = 'ws://localhost:8080/game';

@Injectable({ providedIn: 'root'})
export class ConnectivityService {
  private readonly client: Client;
  private activated = false;

  constructor() {
    this.client = new Client({
      webSocketFactory: () => new SockJS(SOCKET_URL) as IStompSocket,
    });
  }

  send<E>(endpoint: string, payload: E): void {
    this.client.publish({
      destination: endpoint,
      body: JSON.stringify(payload)
    });
  }

  on<E>(topic: string, handler: (message: E) => unknown): void {
    if (!this.activated) {
      this.client.activate();
      this.activated = true;
    }

    this.client.subscribe(topic, ({ body }) => {
      const message = JSON.parse(body) as E;
      handler(message);
    });
  }
}
