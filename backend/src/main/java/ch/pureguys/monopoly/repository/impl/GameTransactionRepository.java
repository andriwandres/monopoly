package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.GameTransaction;
import ch.pureguys.monopoly.domain.Property;

public interface GameTransactionRepository extends JpaRepository<GameTransaction, Long>
{
}
