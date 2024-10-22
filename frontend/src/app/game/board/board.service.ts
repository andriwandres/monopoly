import { Injectable } from '@angular/core';
import { Board } from '../../shared/domain/board';

@Injectable({
  providedIn: 'root'
})
export class BoardService {
  getBoard(): Board {
    return {
      topTiles: allLocations.slice(0, 9),
      rightTiles: allLocations.slice(9, 18),
      bottomTiles: allLocations.slice(19, 28),
      leftTiles: allLocations.slice(27, 37)
    };
  }
}

const allLocations = [
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
  { name: 'Lucerne', price: 800 },
  { name: 'Zurich', price: 1000 },
  { name: 'Geneva', price: 1200 },
];
