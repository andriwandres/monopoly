package ch.pureguys.monopoly.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;

	@Column(nullable = false, length = 20)
	private String type; // 'chance' or 'community_chest'

	@Column(nullable = false)
	private String description;

	@Lob
	@Column(nullable = false)
	private String effect; // JSON string representing the effect

	@OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
	private List<GameCard> gameCards;
}
