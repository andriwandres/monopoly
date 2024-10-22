package ch.pureguys.monopoly.common.util;

public class RandomHashUtil
{
	private static final int DEFAULT_HASH_LENGTH = 10;

	public static String generateRandomHash ()
	{
		String hash = "";
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for ( int i = 0; i < DEFAULT_HASH_LENGTH; i++ )
		{
			int randomIndex = (int) ( Math.random() * characters.length() );
			hash += characters.charAt( randomIndex );
		}
		return hash;
	}
}
