export interface Player {
  gamePlayerId: number
  name: string
  money: number
  position: number
  inJail: boolean
  jailTurns: number
  turnOrder: number
  numberOfPardonCards: number
}
