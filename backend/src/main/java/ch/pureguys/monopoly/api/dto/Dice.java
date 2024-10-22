package ch.pureguys.monopoly.api.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Dice
{
	private final int left;
	private final int right;

	private Dice ( int left, int right )
	{
		this.left = left;
		this.right = right;
	}

	public static Dice roll ()
	{
		int left = (int) ( Math.random() * 6 ) + 1;
		int right = (int) ( Math.random() * 6 ) + 1;
		return new Dice( left, right );
	}
}
