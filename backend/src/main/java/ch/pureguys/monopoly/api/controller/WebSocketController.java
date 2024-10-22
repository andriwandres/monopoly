package ch.pureguys.monopoly.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController
{
	@MessageMapping( "/chat" )
	@SendTo( "/topic/messages" )
	public Message send ( Message message )
	{
		return message;
	}

	private record Message(String from, String text, String time)
	{
	}
}
