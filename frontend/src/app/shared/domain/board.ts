import { PropertyTile } from "./tile";

export interface Board {
  topTiles: PropertyTile[];
  rightTiles: PropertyTile[];
  bottomTiles: PropertyTile[];
  leftTiles: PropertyTile[];
}
