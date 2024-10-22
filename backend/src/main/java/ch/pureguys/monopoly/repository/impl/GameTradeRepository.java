package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.GameTrade;

public interface GameTradeRepository extends JpaRepository<GameTrade, Long>
{
}