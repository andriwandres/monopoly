package ch.pureguys.monopoly.api.dto;

import java.util.List;

import ch.pureguys.monopoly.domain.GameStatus;
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
public class GameDto
{
	private String publicRoomId;
	private GameStatus status;
	private List<GamePlayerDto> players;
	private List<GamePropertyDto> properties;
	private String createdAt;
}
