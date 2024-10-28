package ch.pureguys.monopoly.api.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import ch.pureguys.monopoly.service.impl.GameRoomService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GameServer
{
	private final SimpMessagingTemplate messagingTemplate;
	private final GameRoomService gameRoomService;

	@MessageMapping( "/join" ) // comes from frontend (/app/join)
	@SendTo( "/topic/room" ) // backend sends to frontend
	public GameJoinMessage send ( GameJoinMessage message )
	{
		gameRoomService.joinRoom( message.roomId(), message.playerId());
		messagingTemplate.convertAndSend("/topic/room/" + message.roomId(), message);
		return message;
	}

	private record GameJoinMessage(String roomId, String playerId)
	{
	}
}
