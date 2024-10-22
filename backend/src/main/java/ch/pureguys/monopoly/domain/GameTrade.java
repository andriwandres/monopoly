package ch.pureguys.monopoly.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table( name = "GameTrades" )
public class GameTrade
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long tradeId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "initiator_id", nullable = false )
	private GamePlayer initiator;

	@ManyToOne
	@JoinColumn( name = "recipient_id", nullable = false )
	private GamePlayer recipient;

	@Lob
	@Column( name = "initiator_offer", nullable = false )
	private String initiatorOffer; // JSON string

	@Lob
	@Column( name = "recipient_offer", nullable = false )
	private String recipientOffer; // JSON string

	@Column( nullable = false, length = 20 )
	private String status; // 'pending', 'accepted', 'declined'

	@Column( name = "created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

}

