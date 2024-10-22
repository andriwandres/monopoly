package ch.pureguys.monopoly.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table( name = "GameCards", uniqueConstraints = {
		@UniqueConstraint( columnNames = { "game_id", "card_id" } )
} )
public class GameCard
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "game_card_id" )
	private Long gameCardId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "card_id", nullable = false )
	private Card card;

	@ManyToOne
	@JoinColumn( name = "player_id", nullable = false )
	private GamePlayer drawnBy;

	@Column( name = "game_card_created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();
}

