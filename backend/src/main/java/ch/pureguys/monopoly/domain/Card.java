package ch.pureguys.monopoly.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private Long cardId;

	@Column( nullable = false, length = 20 )
	private CardType type; // 'chance' or 'community_chest'

	@Column( nullable = false )
	private String description;

	@Lob
	@Column( nullable = false )
	private String effect; // JSON string representing the effect

	@OneToMany( mappedBy = "card", cascade = CascadeType.ALL )
	private List<GameCard> gameCards;
}
