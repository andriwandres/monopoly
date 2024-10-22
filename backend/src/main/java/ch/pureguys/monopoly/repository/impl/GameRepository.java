package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.Game;
import ch.pureguys.monopoly.domain.Property;

public interface GameRepository extends JpaRepository<Game, Long>
{
}
