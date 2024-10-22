import { Injectable } from '@angular/core';
import { PropertyTile } from '../../shared/domain/tile';

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  getBoard(): PropertyTile[] {
    return [
      { name: 'Lucerne', price: 800 },
      { name: 'Zurich', price: 1000 },
      { name: 'Geneva', price: 1200 },
    ];
  }
}
