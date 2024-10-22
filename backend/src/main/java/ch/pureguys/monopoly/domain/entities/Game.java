package ch.pureguys.monopoly.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import ch.pureguys.monopoly.domain.GameStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table( name = "Games" )
public class Game
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long gameId;

	@Column( name = "created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column( nullable = false, length = 20 )
	private GameStatus status;

	@ManyToOne
	@JoinColumn( name = "current_turn_player_id" )
	private GamePlayer currentTurnPlayer;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GamePlayer> gamePlayers;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GameProperty> gameProperties;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GameCard> gameCards;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GameTransaction> gameTransactions;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GameTrade> gameTrades;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GameEvent> gameEvents;

	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
	private List<GameChatMessage> gameChatMessages;

}

