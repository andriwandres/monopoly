package ch.pureguys.monopoly.domain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table( name = "GamePlayers", uniqueConstraints = {
		@UniqueConstraint( columnNames = { "game_id", "player_id" } ),
		@UniqueConstraint( columnNames = { "game_id", "player_name" } )
} )
public class GamePlayer
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long gamePlayerId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "player_id" )
	private Player player;

	@Column( nullable = false )
	private String name;

	@Column( nullable = false )
	private Integer money = 1500;

	@Column( nullable = false )
	private Integer position = 0;

	@Column( name = "in_jail", nullable = false )
	private Boolean inJail = false;

	@Column( name = "jail_turns", nullable = false )
	private Integer jailTurns = 0;

	@Column( name = "turn_order", nullable = false )
	private Integer turnOrder;

	@Column( name = "number_of_pardon_cards", nullable = false )
	private Integer numberOfPardonCards = 0;


	@OneToMany( mappedBy = "currentTurnPlayer" )
	private List<Game> games;

	@OneToMany( mappedBy = "owner" )
	private List<GameProperty> ownedProperties;

	@OneToMany( mappedBy = "fromPlayer" )
	private List<GameTransaction> transactionsFrom;

	@OneToMany( mappedBy = "toPlayer" )
	private List<GameTransaction> transactionsTo;

	@OneToMany( mappedBy = "initiator" )
	private List<GameTrade> initiatedGameTrades;

	@OneToMany( mappedBy = "recipient" )
	private List<GameTrade> receivedGameTrades;

	@OneToMany( mappedBy = "player" )
	private List<GameEvent> gameEvents;

	@OneToMany( mappedBy = "drawnBy" )
	private List<GameCard> gameCards;

}

