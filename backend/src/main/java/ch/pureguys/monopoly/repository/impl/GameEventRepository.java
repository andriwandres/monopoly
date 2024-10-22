package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.GameEvent;
import ch.pureguys.monopoly.domain.Property;

public interface GameEventRepository extends JpaRepository<GameEvent, Long>
{
}
