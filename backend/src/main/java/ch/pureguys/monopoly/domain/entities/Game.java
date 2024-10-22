package ch.pureguys.monopoly.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import ch.pureguys.monopoly.domain.GameStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table( name = "Games", uniqueConstraints = {
		@UniqueConstraint( columnNames = { "public_room_id" } )
} )
public class Game
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "game_id" )
	private Long gameId;

	@ManyToOne
	@JoinColumn( name = "board_id", nullable = false )
	private Board board;

	@Column( name = "game_public_room_id", nullable = false )
	private String publicRoomId;

	@Enumerated( EnumType.STRING)
	@Column( name = "game_status", nullable = false, length = 20 )
	private GameStatus status;

	@Builder.Default
	@Column( name = "game_created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();


	//Relations
	@ManyToOne
	@JoinColumn( name = "game_current_turn_player_id" )
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

