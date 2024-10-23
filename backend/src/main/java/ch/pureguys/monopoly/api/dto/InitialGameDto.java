package ch.pureguys.monopoly.api.dto;

import java.time.LocalDateTime;

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
public class InitialGameDto
{
	private String publicRoomId;
	private GameStatus status;
	private LocalDateTime createdAt;
}
