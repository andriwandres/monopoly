package ch.pureguys.monopoly.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.pureguys.monopoly.api.dto.InitialGameDto;
import ch.pureguys.monopoly.common.util.RandomHashUtil;
import ch.pureguys.monopoly.domain.GameStatus;
import ch.pureguys.monopoly.domain.entities.Board;
import ch.pureguys.monopoly.domain.entities.Game;
import ch.pureguys.monopoly.domain.entities.GameProperty;
import ch.pureguys.monopoly.domain.entities.Property;
import ch.pureguys.monopoly.mapper.impl.GameMapper;
import ch.pureguys.monopoly.repository.impl.BoardRepository;
import ch.pureguys.monopoly.repository.impl.GamePropertyRepository;
import ch.pureguys.monopoly.repository.impl.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping( "/game" )
public class GameController
{

	private final GameRepository gameRepository;
	private final BoardRepository boardRepository;
	private final GamePropertyRepository gamePropertyRepository;

	@PostMapping( "/start" )
	public ResponseEntity<InitialGameDto> create ()
	{
		//Todo: get board by id
		Board board = boardRepository.findById( 1L ).orElse( null );

		if ( board == null )
		{
			log.error( "Board not found" );
			return ResponseEntity.badRequest().body( null );
		}

		Game newGame = Game.builder()
				.board( board )
				.status( GameStatus.WAITING )
				.publicRoomId( RandomHashUtil.generateRandomHash() )
				.build();

		Game created = gameRepository.save( newGame );

		log.info( "New Game created" );
		log.info( "Game ID: " + created.getGameId() );
		log.info( "Room ID: " + created.getPublicRoomId() );

		// Detach data, Exception occurred when using lazy loading in Thread
		List<Property> properties = new ArrayList<>(board.getProperties());

		CompletableFuture<List<GameProperty>> gamePropertiesFuture = CompletableFuture.supplyAsync( () -> {
			try
			{
				List<GameProperty> gameProperties = properties.stream().map( property ->
					GameProperty.builder()
							.game( created )
							.property( property )
							.owner( null )
							.build() ).toList();

				return gamePropertyRepository.saveAll( gameProperties );
			}
			catch ( Exception e )
			{
				log.error( "Game properties creation failed", e );
				throw new RuntimeException( e );
			}
		} );

		gamePropertiesFuture.thenAccept( gameProperties -> {
			//Todo notify via websocket (json)
			log.info( "Game properties created" );
			log.info( "Game properties count: " + gameProperties.size() );
		} );

		return ResponseEntity.ok( GameMapper.INSTANCE.gameToInitialGameDto( newGame ) );
	}
}
