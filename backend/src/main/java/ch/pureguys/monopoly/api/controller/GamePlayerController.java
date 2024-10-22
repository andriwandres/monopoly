package ch.pureguys.monopoly.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.pureguys.monopoly.domain.entities.Game;
import ch.pureguys.monopoly.domain.entities.GamePlayer;
import ch.pureguys.monopoly.repository.impl.GamePlayerRepository;
import ch.pureguys.monopoly.repository.impl.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping( "/game_player" )
public class GamePlayerController
{

	private final GameRepository gameRepository;
	private final GamePlayerRepository gamePlayerRepository;

	@PostMapping
	public ResponseEntity<String> createUser ( @RequestParam String name, @RequestParam String roomId )
	{
		Game game = gameRepository.findByPublicRoomId( roomId );

		if ( game == null )
		{
			log.error( "Game not found" );
			return ResponseEntity.badRequest().body( "Game not found" );
		}

		GamePlayer newPlayer = GamePlayer.builder()
				.name( name )
				.game( game )
				.build();

		GamePlayer created = gamePlayerRepository.save( newPlayer );
		log.info( "New GamePlayer created" );
		log.info( "GamePlayer ID: " + created.getGamePlayerId() );
		log.info( "GamePlayer Name: " + created.getName() );

		return ResponseEntity.ok( name );
	}
}
