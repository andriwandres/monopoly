package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.Board;

public interface BoardRepository extends JpaRepository<Board, Long>
{
}
