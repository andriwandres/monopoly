package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>
{
}
