package ch.pureguys.monopoly.controller;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Dice
{
	private final int dice1;
	private final int dice2;

	private Dice ( int dice1, int dice2 )
	{
		this.dice1 = dice1;
		this.dice2 = dice2;
	}

	public static Dice roll ()
	{
		int dice1 = (int) ( Math.random() * 6 ) + 1;
		int dice2 = (int) ( Math.random() * 6 ) + 1;
		return new Dice( dice1, dice2 );
	}
}
