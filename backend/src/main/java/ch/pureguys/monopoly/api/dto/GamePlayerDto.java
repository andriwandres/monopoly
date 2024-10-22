package ch.pureguys.monopoly.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GamePlayerDto
{
	private Long gamePlayerId;
	private String name;
	private Integer money;
	private Integer position;
	private Boolean inJail;
	private Integer jailTurns;
	private Integer turnOrder;
	private Integer numberOfPardonCards;
}
