package ch.pureguys.monopoly.mapper.impl;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ch.pureguys.monopoly.api.dto.GamePropertyDto;
import ch.pureguys.monopoly.domain.entities.GameProperty;

@Mapper
public interface GamePropertyMapper
{
	GamePropertyMapper INSTANCE = Mappers.getMapper( GamePropertyMapper.class );

	@Mapping( source = "owner.gamePlayerId", target = "ownerId" )
	@Mapping( source = "property.positionIndex", target = "positionIndex" )
	@Mapping( source = "property.name", target = "name" )
	@Mapping( source = "property.type", target = "type" )
	@Mapping( source = "property.colorGroup", target = "colorGroup" )
	@Mapping( source = "property.price", target = "price" )
	@Mapping( source = "property.mortgageValue", target = "mortgageValue" )
	@Mapping( source = "property.houseCost", target = "houseCost" )
	@Mapping( source = "property.hotelCost", target = "hotelCost" )
	@Mapping( source = "property.rentBase", target = "rentBase" )
	@Mapping( source = "property.rentAllProperties", target = "rentAllProperties" )
	@Mapping( source = "property.rentWithOneHouse", target = "rentWithOneHouse" )
	@Mapping( source = "property.rentWithTwoHouses", target = "rentWithTwoHouses" )
	@Mapping( source = "property.rentWithThreeHouses", target = "rentWithThreeHouses" )
	@Mapping( source = "property.rentWithFourHouses", target = "rentWithFourHouses" )
	@Mapping( source = "property.rentWithHotel", target = "rentWithHotel" )
	GamePropertyDto gamePropertyToGamePropertyDto ( GameProperty gameProperty );

}
