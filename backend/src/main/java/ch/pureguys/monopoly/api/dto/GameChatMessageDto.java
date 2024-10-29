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
public class GameChatMessageDto
{
	private Long gameChatMessageId;
	private Long fromPlayerId;
	private String fromPlayerName;
	private String text;
	private String createdAt;
}
