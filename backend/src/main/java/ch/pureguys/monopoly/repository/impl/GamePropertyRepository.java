package ch.pureguys.monopoly.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.pureguys.monopoly.domain.entities.GameProperty;

public interface GamePropertyRepository extends JpaRepository<GameProperty, Long>
{
	@Query( "SELECT g FROM GameProperty g WHERE g.game.gameId = :gameId" )
	List<GameProperty> findAllByGameId ( Long gameId );
}
