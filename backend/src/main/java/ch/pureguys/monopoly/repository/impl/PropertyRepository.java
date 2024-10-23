package ch.pureguys.monopoly.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.pureguys.monopoly.domain.entities.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>
{
	@Query( "SELECT p FROM Property p WHERE p.board.boardId = :boardId" )
	List<Property> findAllByBoardId ( long boardId );

}
