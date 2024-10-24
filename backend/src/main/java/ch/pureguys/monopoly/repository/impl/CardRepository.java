package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long>
{
}
