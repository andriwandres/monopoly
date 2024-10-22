package ch.pureguys.monopoly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ch.pureguys.monopoly.domain.ChatMessage;

@Controller
public class WebSocketController
{
	@MessageMapping( "/chat" )
	@SendTo( "/topic/messages" )
	public ChatMessage send ( ChatMessage message )
	{
		String time = new SimpleDateFormat( "HH:mm" ).format( new Date() );
		return new ChatMessage( message.getFrom(), message.getText(), time );
	}
}
