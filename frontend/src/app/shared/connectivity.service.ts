import { Injectable } from '@angular/core';
import { Client, IStompSocket } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

const SOCKET_URL = 'http://localhost:8080/monopoly';

@Injectable({ providedIn: 'root'})
export class ConnectivityService {
  private readonly client: Client;

  constructor() {
    this.client = new Client({
      webSocketFactory: () => new SockJS(SOCKET_URL) as IStompSocket,
    });

    this.client.activate();
  }

  send<E>(endpoint: string, payload: E): void {
    this.client.publish({
      destination: endpoint,
      body: JSON.stringify(payload)
    });
  }

  on<E>(topic: string, handler: (message: E) => unknown): void {
    this.client.subscribe(topic, ({ body }) => {
      const message = JSON.parse(body) as E;
      handler(message);
    });
  }
}
