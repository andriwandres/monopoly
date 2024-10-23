package ch.pureguys.monopoly.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.pureguys.monopoly.domain.entities.GamePlayer;

public interface GamePlayerRepository extends JpaRepository<GamePlayer, Long>
{
	@Query( "SELECT g FROM GamePlayer g WHERE g.game.gameId = :gameId" )
	List<GamePlayer> findAllByGameId ( Long gameId );
}
