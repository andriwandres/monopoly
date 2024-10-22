package ch.pureguys.monopoly.domain;

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
	private Long playerId;

	@Column( unique = true, nullable = false, length = 50 )
	private String username;

	@Column( unique = true, nullable = false, length = 100 )
	private String email;

	@Column( nullable = false, length = 255 )
	private String passwordHash;

	@Column( length = 255 )
	private String avatar;

	@Column( name = "created_at", nullable = false )
	private LocalDateTime createdAt = LocalDateTime.now();

	// Relationships
	@OneToMany( mappedBy = "gamePlayer" )
	private List<GamePlayer> gamePlayers;

}

