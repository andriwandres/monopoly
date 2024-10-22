package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.GameEvent;

public interface GameEventRepository extends JpaRepository<GameEvent, Long>
{
}
