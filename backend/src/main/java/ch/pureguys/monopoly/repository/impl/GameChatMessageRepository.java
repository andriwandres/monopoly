package ch.pureguys.monopoly.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.pureguys.monopoly.domain.entities.GameChatMessage;

public interface GameChatMessageRepository extends JpaRepository<GameChatMessage, Long>
{
	@Query( "SELECT g FROM GameChatMessage g WHERE g.game.gameId = :gameId" )
	List<GameChatMessage> findAllByGameId ( Long gameId );
}
