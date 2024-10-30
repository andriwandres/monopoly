import { Injectable } from '@angular/core';
import { HubConnection, HubConnectionBuilder } from '@microsoft/signalr';
import { BehaviorSubject, filter, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class SocketService {
  private readonly connectionSubject =
    new BehaviorSubject<HubConnection | null>(null);

  private readonly connection$ = this.connectionSubject
    .asObservable()
    .pipe(filter(Boolean));

  connect(gameCode: string, nickname: string, color: string): Promise<void> {
    const connection = new HubConnectionBuilder()
      .withUrl(this.buildSocketUrl(gameCode, nickname, color))
      .build();

    this.connectionSubject.next(connection);

    return connection.start();
  }

  on<M = void>(event: string): Observable<M> {
    return new Observable<M>((observer) => {
      this.connection$.subscribe((connection) => {
        connection.on(event, (message: M | undefined) => {
          observer.next(message);
        });
      });
    });
  }

  send(method: string, ...args: unknown[]): void {
    this.connection$.subscribe((connection) => {
      if (args?.length) {
        connection.invoke(method, args);
      } else {
        connection.invoke(method);
      }
    });
  }

  private buildSocketUrl(
    gameCode: string,
    nickname: string,
    color: string
  ): string {
    return `${environment.serverUrl}/game-hub?gameCode=${gameCode}&nickname=${nickname}&color=${color}`;
  }
}
