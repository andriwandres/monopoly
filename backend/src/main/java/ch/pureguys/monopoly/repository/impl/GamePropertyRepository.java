package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.GameProperty;
import ch.pureguys.monopoly.domain.Property;

public interface GamePropertyRepository extends JpaRepository<GameProperty, Long>
{
}
