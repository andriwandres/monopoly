package ch.pureguys.monopoly.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage
{
	private String from;
	private String text;
	private String time;

}

