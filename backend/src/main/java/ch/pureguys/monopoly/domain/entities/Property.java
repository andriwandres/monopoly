package ch.pureguys.monopoly.domain.entities;

import java.util.List;

import ch.pureguys.monopoly.domain.FieldType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Column( name = "property_id" )
	private Long propertyId;

	@ManyToOne
	@JoinColumn( name = "board_id", nullable = false )
	private Board board;

	@Column( name = "property_position_index", nullable = false )
	private Integer positionIndex;

	@Column( name = "property_name", nullable = false, length = 100 )
	private String name;

	@Enumerated( EnumType.STRING )
	@Column( name = "property_name", nullable = false, length = 20 )
	private FieldType type;

	@Column( name = "property_color_group", length = 20 )
	private String colorGroup;

	@Column( name = "property_price" )
	private Integer price;

	@Column( name = "property_mortgage_value" )
	private Integer mortgageValue;

	@Column( name = "property_house_cost" )
	private Integer houseCost;

	@Column( name = "property_hotel_cost" )
	private Integer hotelCost;

	@Column( name = "property_rent_base" )
	private Integer rentBase;

	@Column( name = "property_rent_all_properties" )
	private Integer rentAllProperties;

	@Column( name = "property_rent_with_one_house" )
	private Integer rentWithOneHouse;

	@Column( name = "property_rent_with_two_houses" )
	private Integer rentWithTwoHouses;

	@Column( name = "property_rent_with_three_houses" )
	private Integer rentWithThreeHouses;

	@Column( name = "property_rent_with_four_houses" )
	private Integer rentWithFourHouses;

	@Column( name = "property_rent_with_hotel" )
	private Integer rentWithHotel;

	@OneToMany( mappedBy = "property", cascade = CascadeType.ALL )
	private List<GameProperty> gameProperties;

}

