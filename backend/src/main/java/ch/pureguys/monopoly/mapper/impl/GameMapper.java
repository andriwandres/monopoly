package ch.pureguys.monopoly.mapper.impl;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ch.pureguys.monopoly.api.dto.GameDto;
import ch.pureguys.monopoly.api.dto.GamePlayerDto;
import ch.pureguys.monopoly.api.dto.GamePropertyDto;
import ch.pureguys.monopoly.api.dto.InitialGameDto;
import ch.pureguys.monopoly.domain.entities.Game;

@Mapper
public interface GameMapper
{
	GameMapper INSTANCE = Mappers.getMapper( GameMapper.class );

	InitialGameDto gameToInitialGameDto ( Game game );

	@Mapping( source = "players", target = "players" )
	@Mapping( source = "properties", target = "properties" )
	GameDto gameToGameDto ( Game game, List<GamePlayerDto> players, List<GamePropertyDto> properties );

}
