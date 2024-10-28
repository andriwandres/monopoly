package ch.pureguys.monopoly.api.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import ch.pureguys.monopoly.domain.entities.Game;
import ch.pureguys.monopoly.domain.entities.GamePlayer;
import ch.pureguys.monopoly.repository.impl.GamePlayerRepository;
import ch.pureguys.monopoly.repository.impl.GameRepository;
import ch.pureguys.monopoly.service.impl.GameRoomService;
import ch.pureguys.monopoly.service.impl.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class GameServer
{
	private final SimpMessagingTemplate messagingTemplate;
	private final GameRoomService gameRoomService;
	private final GameRepository gameRepository;
	private final GamePlayerRepository gamePlayerRepository;
	private final GameService gameService;

	@MessageMapping( "/join" ) // comes from frontend (/app/join)
	//@SendTo( "/topic/game/{roomId}" ) // backend sends to frontend
	public void join ( GameJoinMessage message )
	{
		Game game = gameRepository.findByPublicRoomId( message.roomId() );

		if ( game == null )
		{
			log.error( "Game not found" );
			return;
		}

		GamePlayer newPlayer = GamePlayer.builder()
				.name( message.nickName() )
				.game( game )
				.build();

		GamePlayer created = gamePlayerRepository.save( newPlayer );

		log.info( "New GamePlayer created" );
		log.info( "GamePlayer ID: " + created.getGamePlayerId() );
		log.info( "GamePlayer Name: " + created.getName() );

		gameRoomService.joinRoom( message.roomId(), created.getGamePlayerId() );

		//websocket response for already joined players
		String destination = String.format( "/topic/game/%s/event/payerJoined", message.roomId() );
		messagingTemplate.convertAndSend( destination, message );

		//websocket response for new joined player
		destination = String.format( "/topic/game/%s", message.roomId() );
		messagingTemplate.convertAndSend( destination, gameService.getCurrentGameDto( message.roomId() ) );
	}

	@MessageMapping( "/throwDice" ) // comes from frontend (/app/throwDice)
	//@SendTo( "/topic/game/{roomId}/event/diceThrown" ) // backend sends to frontend
	public void throwDice ( GameJoinMessage message )
	{
		//gameRoomService.joinRoom( message.roomId(), message.playerId() );
		String destination = String.format( "/topic/game/%s/event/diceThrown", message.roomId() );
		//save player and add to game
		messagingTemplate.convertAndSend( destination, message );
		//list players and return
	}

	private record GameJoinMessage(String roomId, String nickName, String hexColor)
	{
	}
}
