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
@Table( name = "GameEvents" )
public class GameEvent
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long eventId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "player_id", nullable = false )
	private GamePlayer player;

	@Column( name = "event_type", length = 50, nullable = false )
	private String eventType; // Refactor to ENUM

	@Lob
	@Column( name = "details" )
	private String details; // Use JSON to store event details

	@Column( name = "value" )
	private Integer value; //current money, property value, houses, pardon card, etc.

	@Column( name = "created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column( name = "event_sequence", nullable = false )
	private Integer eventSequence;

}

