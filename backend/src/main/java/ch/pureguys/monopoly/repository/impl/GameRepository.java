package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>
{
}
