import { Player } from './player';

export interface PropertyTile {
  price: number;
  name: string;
  owner?: Player;
}
