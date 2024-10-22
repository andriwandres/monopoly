package ch.pureguys.monopoly.mapper.impl;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ch.pureguys.monopoly.api.dto.InitialGameDto;
import ch.pureguys.monopoly.domain.entities.Game;

@Mapper
public interface GameMapper
{
	GameMapper INSTANCE = Mappers.getMapper( GameMapper.class );

	InitialGameDto gameToInitialGameDto ( Game game );
}
