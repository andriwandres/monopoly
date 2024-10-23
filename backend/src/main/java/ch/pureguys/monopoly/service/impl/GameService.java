package ch.pureguys.monopoly.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import ch.pureguys.monopoly.api.dto.GameDto;
import ch.pureguys.monopoly.api.dto.GamePlayerDto;
import ch.pureguys.monopoly.api.dto.GamePropertyDto;
import ch.pureguys.monopoly.domain.entities.Game;
import ch.pureguys.monopoly.domain.entities.GameProperty;
import ch.pureguys.monopoly.domain.entities.Property;
import ch.pureguys.monopoly.mapper.impl.GameMapper;
import ch.pureguys.monopoly.mapper.impl.GamePlayerMapper;
import ch.pureguys.monopoly.mapper.impl.GamePropertyMapper;
import ch.pureguys.monopoly.repository.impl.GamePlayerRepository;
import ch.pureguys.monopoly.repository.impl.GamePropertyRepository;
import ch.pureguys.monopoly.repository.impl.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService
{
	private final GamePropertyRepository gamePropertyRepository;
	private final GamePlayerRepository gamePlayerRepository;
	private final PropertyRepository propertyRepository;

	public void prepareGameAsync ( long boardId, Game game )
	{
		//For high load maybe we can use a thread pool
		CompletableFuture.runAsync( () -> {
			try
			{
				List<Property> properties = propertyRepository.findAllByBoardId( boardId );
				List<GameProperty> gameProperties = properties.stream().map( property ->
						GameProperty.builder()
								.game( game )
								.property( property )
								.owner( null )
								.build() ).toList();

				List<GameProperty> savedGameProperties = gamePropertyRepository.saveAll( gameProperties );
				//TBD does the frontend request the full game data or does the backend send it as soon as it is ready?

				List<GamePropertyDto> gamePropertyDtos = savedGameProperties.stream()
						.map( GamePropertyMapper.INSTANCE::gamePropertyToGamePropertyDto )
						.toList();

				List<GamePlayerDto> gamePlayerDtos = gamePlayerRepository.findAllByGameId( game.getGameId() ).stream()
						.map( GamePlayerMapper.INSTANCE::gamePlayerToGamePlayerDto )
						.toList();

				GameDto gameDto = GameMapper.INSTANCE.gameToGameDto( game, gamePlayerDtos, gamePropertyDtos );
				log.info( "GameDto: {}", gameDto );
				//Todo notify via websocket (json)
				log.info( "Game properties created" );
				log.info( "Game properties count: {}", gameProperties.size() );
			}
			catch ( Exception e )
			{
				log.error( "prepareGameAsync failed", e );
				throw new RuntimeException( e );
			}
		} );
	}
}
