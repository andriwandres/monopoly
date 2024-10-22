package ch.pureguys.monopoly.domain;

import jakarta.persistence.*;
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
@Table(name = "GamePlayers", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"game_id", "player_id"})
})
public class GamePlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gamePlayerId;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;

	@Column(nullable = false)
	private Integer money = 1500;

	@Column(nullable = false)
	private Integer position = 0;

	@Column(name = "in_jail", nullable = false)
	private Boolean inJail = false;

	@Column(name = "jail_turns", nullable = false)
	private Integer jailTurns = 0;

	@Column(name = "turn_order", nullable = false)
	private Integer turnOrder;

	@Column(name = "number_of_pardon_cards", nullable = false)
	private Integer numberOfPardonCards = 0;

}

