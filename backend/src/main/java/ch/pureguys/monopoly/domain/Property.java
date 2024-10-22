package ch.pureguys.monopoly.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table( name = "Properties", uniqueConstraints = {
		@UniqueConstraint( columnNames = { "property_id", "board_id", "position_Index" } )
} )
public class Property
{
	//Properties can be streets, railroads, utilities aswell as actionfields.

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long propertyId;

	@ManyToOne
	@JoinColumn( name = "board_id", nullable = false )
	private Board board;

	@Column( nullable = false )
	private Integer positionIndex;

	@Column( nullable = false, length = 100 )
	private String name;

	// add boolean isActionField to ENUM
	@Column( nullable = false, length = 20 )
	private String type; // 'street', 'railroad', 'utility', etc.

	@Column( name = "color_group", length = 20 )
	private String colorGroup;

	@Column
	private Integer price;

	@Column( name = "mortgage_value" )
	private Integer mortgageValue;

	@Column( name = "house_cost" )
	private Integer houseCost;

	@Column( name = "hotel_cost" )
	private Integer hotelCost;

	@Column( name = "rent_base" )
	private Integer rentBase;

	@Column( name = "rent_all_properties" )
	private Integer rentAllProperties;

	@Column( name = "rent_with_one_house" )
	private Integer rentWithOneHouse;

	@Column( name = "rent_with_two_houses" )
	private Integer rentWithTwoHouses;

	@Column( name = "rent_with_three_houses" )
	private Integer rentWithThreeHouses;

	@Column( name = "rent_with_four_houses" )
	private Integer rentWithFourHouses;

	@Column( name = "rent_with_hotel" )
	private Integer rentWithHotel;

	@OneToMany( mappedBy = "property", cascade = CascadeType.ALL )
	private List<GameProperty> gameProperties;

}

