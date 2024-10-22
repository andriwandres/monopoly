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
	@Column( name = "transaction_id" )
	private Long transactionId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "transaction_from_player_id" )
	private GamePlayer fromPlayer;

	@ManyToOne
	@JoinColumn( name = "transaction_to_player_id" )
	private GamePlayer toPlayer;

	@Column( name = "transaction_amount", nullable = false )
	private Integer amount;

	@Column( name = "transaction_type", nullable = false, length = 50 )
	private String transactionType;

	@Builder.Default
	@Column( name = "transaction_created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

}
