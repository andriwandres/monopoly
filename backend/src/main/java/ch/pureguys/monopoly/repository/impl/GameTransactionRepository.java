package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.GameTransaction;

public interface GameTransactionRepository extends JpaRepository<GameTransaction, Long>
{
}
