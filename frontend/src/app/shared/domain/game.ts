import {Player} from './player';
import {Property} from './property';
import {ChatMessage} from './chatMessage';

export interface Game {
  publicRoomId: string
  status: GameStatus
  players: Player[]
  properties: Property[]
  chatMessages: ChatMessage[]
  createdAt: string
}

export enum GameStatus {
  WAITING,
  IN_PROGRESS,
  FINISHED
}
