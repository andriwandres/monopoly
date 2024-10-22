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
@Table(name = "Events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;

	@Column(name = "event_type", length = 50, nullable = false)
	private String eventType; // Refactor to ENUM

	@Lob
	@Column(name = "details")
	private String details; // Use JSON to store event details

	@Column(name = "value")
	private Integer value; //current money, property value, houses, pardon card, etc.

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "event_sequence", nullable = false)
	private Integer eventSequence;

}

