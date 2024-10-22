package ch.pureguys.monopoly.domain.entities;

import java.util.List;

import ch.pureguys.monopoly.domain.CardType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table( name = "Cards" )
public class Card
{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "card_id" )
	private Long cardId;

	@Enumerated( EnumType.STRING)
	@Column( name="card_type", nullable = false, length = 20 )
	private CardType type;

	@Column( name="card_description", nullable = false )
	private String description;

	@Lob
	@Column( name="card_effect",  nullable = false )
	private String effect; // JSON string representing the effect

	@OneToMany( mappedBy = "card", cascade = CascadeType.ALL )
	private List<GameCard> gameCards;
}
