package ch.pureguys.monopoly.mapper.impl;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ch.pureguys.monopoly.api.dto.GameChatMessageDto;
import ch.pureguys.monopoly.api.dto.GamePlayerDto;
import ch.pureguys.monopoly.domain.entities.GameChatMessage;

@Mapper
public interface GameChatMessageMapper
{
	GameChatMessageMapper INSTANCE = Mappers.getMapper( GameChatMessageMapper.class );

	@Mapping( source = "from.gamePlayerId", target = "fromPlayerId" )
	@Mapping( source = "from.name", target = "fromPlayerName" )
	GameChatMessageDto gameChatMessageToGameChatMessageDto ( GameChatMessage gameChatMessage );
}
