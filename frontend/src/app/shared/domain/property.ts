export interface Property {
  gamePropertyId: number
  ownerId: number
  positionIndex: number
  name: string
  type: FieldType
  colorGroup: string
  price: number
  mortgageValue: number
  houseCost: number
  hotelCost: number
  rentBase: number
  rentAllProperties: number
  rentWithOneHouse: number
  rentWithTwoHouses: number
  rentWithThreeHouses: number
  rentWithFourHouses: number
  rentWithHotel: number
  housesBuilt: number
  hasHotel: boolean
  isMortgaged: boolean
}

export enum FieldType {
  START,
  PROPERTY,
  COMPANY,
  AIRPORT,
  TREASURE,
  SURPRISE,
  TAX,
  JAIL,
  VACATION,
  GO_TO_JAIL
}
