package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.GameProperty;

public interface GamePropertyRepository extends JpaRepository<GameProperty, Long>
{
}
