package ch.pureguys.monopoly.api.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest
{

	@Test
	void roll ()
	{
		// Arrange & Act
		Dice dice = Dice.roll();

		// Assert
		assertTrue( dice.getLeft() >= 1 && dice.getLeft() <= 6 );
		assertTrue( dice.getRight() >= 1 && dice.getRight() <= 6 );
	}

	@Test
	void rollMany ()
	{
		for ( int i = 0; i < 100; i++ )
		{
			// Arrange & Act
			Dice dice = Dice.roll();

			// Assert
			assertTrue( dice.getLeft() >= 1 && dice.getLeft() <= 6 );
			assertTrue( dice.getRight() >= 1 && dice.getRight() <= 6 );
		}
	}
}