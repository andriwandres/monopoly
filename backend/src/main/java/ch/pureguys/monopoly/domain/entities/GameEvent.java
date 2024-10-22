package ch.pureguys.monopoly.domain.entities;

import java.time.LocalDateTime;

import ch.pureguys.monopoly.domain.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jdk.jfr.Event;
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
	@Column( name = "event_id" )
	private Long eventId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "player_id", nullable = false )
	private GamePlayer player;

	@Enumerated( EnumType.STRING)
	@Column( name = "event_type", nullable = false )
	private EventType eventType; // Refactor to ENUM

	@Lob
	@Column( name = "event_details" )
	private String details; // Use JSON to store event details

	@Column( name = "event_player_value" )
	private Integer playerValue; //current money, property value, houses, pardon card, etc.

	@Column( name = "event_created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column( name = "event_sequence", nullable = false )
	private Integer eventSequence;

}

