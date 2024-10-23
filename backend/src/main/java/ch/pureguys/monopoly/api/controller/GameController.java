package ch.pureguys.monopoly.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.pureguys.monopoly.api.dto.InitialGameDto;
import ch.pureguys.monopoly.common.util.RandomHashUtil;
import ch.pureguys.monopoly.domain.GameStatus;
import ch.pureguys.monopoly.domain.entities.Board;
import ch.pureguys.monopoly.domain.entities.Game;
import ch.pureguys.monopoly.mapper.impl.GameMapper;
import ch.pureguys.monopoly.repository.impl.BoardRepository;
import ch.pureguys.monopoly.repository.impl.GamePropertyRepository;
import ch.pureguys.monopoly.repository.impl.GameRepository;
import ch.pureguys.monopoly.service.impl.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping( "/game" )
public class GameController
{
	public static final long DEFAULT_BOARD_ID = 1L;

	private final GameRepository gameRepository;
	private final BoardRepository boardRepository;
	private final GamePropertyRepository gamePropertyRepository;
	private final GameService gameService;

	@PostMapping( "/start" )
	public ResponseEntity<InitialGameDto> create ()
	{
		//Todo: send board id as parameter
		Board board = boardRepository.findById( DEFAULT_BOARD_ID ).orElse( null );

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

		gameService.prepareGameAsync( DEFAULT_BOARD_ID, created );

		return ResponseEntity.ok( GameMapper.INSTANCE.gameToInitialGameDto( newGame ) );
	}
}
