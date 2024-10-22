package ch.pureguys.monopoly.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table( name = "GameProperties", uniqueConstraints = {
		@UniqueConstraint( columnNames = { "game_id", "property_id" } )
} )
public class GameProperty
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "game_property_id")
	private Long gamePropertyId;

	@ManyToOne
	@JoinColumn( name = "game_id", nullable = false )
	private Game game;

	@ManyToOne
	@JoinColumn( name = "property_id", nullable = false )
	private Property property;

	@ManyToOne
	@JoinColumn( name = "owner_id" )
	private GamePlayer owner;

	@Column( name = "game_property_houses_built", nullable = false )
	private Integer housesBuilt = 0;

	@Column( name = "game_property_has_hotel", nullable = false )
	private Boolean hasHotel = false;

	@Column( name = "game_property_is_mortgaged", nullable = false )
	private Boolean isMortgaged = false;

}
