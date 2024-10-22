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
@Table(name = "GameCards", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"game_id", "card_id"})
})
public class GameCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gameCardId;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "card_id", nullable = false)
	private Card card;

	@Column(name = "is_drawn", nullable = false)
	private Boolean isDrawn = false;
}

