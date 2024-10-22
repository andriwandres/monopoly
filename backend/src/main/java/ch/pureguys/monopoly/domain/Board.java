package ch.pureguys.monopoly.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table( name = "Boards" )
public class Board
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long boardId;

	@Column( nullable = false, length = 100 )
	private String name;

	@Column( nullable = false, length = 100 )
	private String description;
}
