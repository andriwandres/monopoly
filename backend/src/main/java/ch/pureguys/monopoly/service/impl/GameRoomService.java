package ch.pureguys.monopoly.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class GameRoomService
{
	private final Map<String, Set<String>> gameRooms = new HashMap<>();

	public void joinRoom ( String roomId, String playerId )
	{
		gameRooms.computeIfAbsent( roomId, k -> new HashSet<>() ).add( playerId );
		//add to db
	}

	public Set<String> getPlayersInRoom ( String roomId )
	{
		return gameRooms.getOrDefault( roomId, new HashSet<>() );
	}

	public void leaveRoom ( String roomId, String playerId )
	{
		Set<String> players = gameRooms.get( roomId );
		if ( players != null )
		{
			players.remove( playerId );
			if ( players.isEmpty() )
			{
				gameRooms.remove( roomId );
				//remove from db
			}
		}
	}
}

