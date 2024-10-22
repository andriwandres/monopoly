package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pureguys.monopoly.domain.entities.GameChatMessage;

public interface GameChatMessageRepository extends JpaRepository<GameChatMessage, Long>
{
}
