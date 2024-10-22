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
@Table(name = "Games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gameId;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false, length = 20)
	private GameStatus status; // 'waiting', 'in_progress', 'completed'

	@ManyToOne
	@JoinColumn(name = "current_turn_player_id")
	private Player currentTurnPlayer;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<GamePlayer> gamePlayers;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<GameProperty> gameProperties;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<GameCard> gameCards;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Trade> trades;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Event> events;

}

