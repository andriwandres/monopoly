package ch.pureguys.monopoly.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "from_player_id")
	private Player fromPlayer;

	@ManyToOne
	@JoinColumn(name = "to_player_id")
	private Player toPlayer;

	@Column(nullable = false)
	private Integer amount;

	@Column(name = "transaction_type", nullable = false, length = 50)
	private String transactionType;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

}
