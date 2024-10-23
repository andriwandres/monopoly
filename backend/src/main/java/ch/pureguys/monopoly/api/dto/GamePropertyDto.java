package ch.pureguys.monopoly.api.dto;

import ch.pureguys.monopoly.domain.FieldType;

import ch.pureguys.monopoly.domain.entities.GamePlayer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GamePropertyDto
{
	private Long gamePropertyId;
	private Long ownerId;
	private Integer positionIndex;
	private String name;
	private FieldType type;
	private String colorGroup;
	private Integer price;
	private Integer mortgageValue;
	private Integer houseCost;
	private Integer hotelCost;
	private Integer rentBase;
	private Integer rentAllProperties;
	private Integer rentWithOneHouse;
	private Integer rentWithTwoHouses;
	private Integer rentWithThreeHouses;
	private Integer rentWithFourHouses;
	private Integer rentWithHotel;
	private Integer housesBuilt;
	private Boolean hasHotel;
	private Boolean isMortgaged;
}
