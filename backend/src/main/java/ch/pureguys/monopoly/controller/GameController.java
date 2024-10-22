package ch.pureguys.monopoly.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.pureguys.monopoly.common.util.RandomHashUtil;
import ch.pureguys.monopoly.domain.GameStatus;
import ch.pureguys.monopoly.domain.entities.Game;
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

	@PostMapping( "/start" )
	public ResponseEntity<Game> create ()
	{
		Game newGame = Game.builder()
				.status( GameStatus.WAITING )
				.publicRoomId( RandomHashUtil.generateRandomHash() )
				.build();

		Game created = gameRepository.save( newGame );

		log.info( "New Game created" );
		log.info( "Game ID: " + created.getGameId() );
		log.info( "Room ID: " + created.getPublicRoomId() );

		return ResponseEntity.ok( newGame );
	}
}
