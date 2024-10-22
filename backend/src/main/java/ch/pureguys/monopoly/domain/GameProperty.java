package ch.pureguys.monopoly.domain;

import jakarta.persistence.*;
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
@Table(name = "GameProperties", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"game_id", "property_id"})
})
public class GameProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gamePropertyId;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "property_id", nullable = false)
	private Property property;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Player owner;

	@Column(name = "houses_built", nullable = false)
	private Integer housesBuilt = 0;

	@Column(name = "has_hotel", nullable = false)
	private Boolean hasHotel = false;

	@Column(name = "is_mortgaged", nullable = false)
	private Boolean isMortgaged = false;

}
