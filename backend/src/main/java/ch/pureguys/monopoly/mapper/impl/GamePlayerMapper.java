package ch.pureguys.monopoly.mapper.impl;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ch.pureguys.monopoly.api.dto.GamePlayerDto;
import ch.pureguys.monopoly.domain.entities.GamePlayer;

@Mapper
public interface GamePlayerMapper
{
	GamePlayerMapper INSTANCE = Mappers.getMapper( GamePlayerMapper.class );

	GamePlayerDto gamePlayerToGamePlayerDto ( GamePlayer gamePlayer );
}
