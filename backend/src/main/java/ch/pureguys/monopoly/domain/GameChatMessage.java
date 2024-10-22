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
@Table( name = "GameChatMessages" )
public class GameChatMessage
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "game_chat_message_id" )
	private Long gameChatMessageId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "player_id", nullable = false )
	private GamePlayer from;

	@Column( name = "text", nullable = false )
	private String text;

	@Column( name = "created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();
}

