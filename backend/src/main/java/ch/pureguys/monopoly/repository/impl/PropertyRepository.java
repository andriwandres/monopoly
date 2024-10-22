package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>
{
}
