package ch.pureguys.monopoly.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table( name = "Players" )
public class Player
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "player_id" )
	private Long playerId;

	@Column( name = "player_username", unique = true, nullable = false, length = 50 )
	private String username;

	@Column( name = "player_email", unique = true, nullable = false, length = 100 )
	private String email;

	@Column( name= "player_password_hash", nullable = false, length = 255 )
	private String passwordHash;

	@Column( name= "player_avatar", length = 255 )
	private String avatar;

	@Builder.Default
	@Column( name = "player_ created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

	// Relationships
	@OneToMany( mappedBy = "player" )
	private List<GamePlayer> gamePlayers;

}

