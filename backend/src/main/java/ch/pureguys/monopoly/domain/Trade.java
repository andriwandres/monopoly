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
@Table(name = "Trades")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tradeId;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "initiator_id", nullable = false)
	private Player initiator;

	@ManyToOne
	@JoinColumn(name = "recipient_id", nullable = false)
	private Player recipient;

	@Lob
	@Column(name = "initiator_offer", nullable = false)
	private String initiatorOffer; // JSON string

	@Lob
	@Column(name = "recipient_offer", nullable = false)
	private String recipientOffer; // JSON string

	@Column(nullable = false, length = 20)
	private String status; // 'pending', 'accepted', 'declined'

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

}

