package ch.pureguys.monopoly.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;

	@Column(unique = true, nullable = false, length = 50)
	private String username;

	@Column(unique = true, nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 255)
	private String passwordHash;

	@Column(length = 255)
	private String avatar;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	// Relationships
	@OneToMany(mappedBy = "player")
	private List<GamePlayer> gamePlayers;

	@OneToMany(mappedBy = "currentTurnPlayer")
	private List<Game> games;

	@OneToMany(mappedBy = "owner")
	private List<GameProperty> ownedProperties;

	@OneToMany(mappedBy = "fromPlayer")
	private List<Transaction> transactionsFrom;

	@OneToMany(mappedBy = "toPlayer")
	private List<Transaction> transactionsTo;

	@OneToMany(mappedBy = "initiator")
	private List<Trade> initiatedTrades;

	@OneToMany(mappedBy = "recipient")
	private List<Trade> receivedTrades;

	@OneToMany(mappedBy = "player")
	private List<Event> events;

}

