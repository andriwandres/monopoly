package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.pureguys.monopoly.domain.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>
{
	@Query( "SELECT g FROM Game g WHERE g.publicRoomId = :publicRoomId" )
	Game findByPublicRoomId ( String publicRoomId );
}
