package ch.pureguys.monopoly.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ch.pureguys.monopoly.api.dto.Dice;

@Controller
public class DiceController
{
	@MessageMapping( "/dice" )
	@SendTo( "/game/dice_rolled" )
	public ResponseEntity<Dice> requestDice ()
	{
		return ResponseEntity.ok( Dice.roll() );
	}
}
