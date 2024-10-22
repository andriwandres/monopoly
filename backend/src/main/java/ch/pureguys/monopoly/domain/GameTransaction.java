package ch.pureguys.monopoly.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table( name = "GameTransactions" )
public class GameTransaction
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long transactionId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "from_player_id" )
	private GamePlayer fromPlayer;

	@ManyToOne
	@JoinColumn( name = "to_player_id" )
	private GamePlayer toPlayer;

	@Column( nullable = false )
	private Integer amount;

	@Column( name = "transaction_type", nullable = false, length = 50 )
	private String transactionType;

	@Column( name = "created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

}
