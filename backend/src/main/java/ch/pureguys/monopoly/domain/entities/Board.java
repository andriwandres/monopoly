package ch.pureguys.monopoly.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table( name = "Boards" )
public class Board
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "board_id" )
	private Long boardId;

	@Column( name="board_name", nullable = false, length = 100 )
	private String name;

	@Column( name="board_description", nullable = false, length = 100 )
	private String description;

	@OneToMany( mappedBy = "board", cascade = CascadeType.ALL )
	private List<Property> properties;
}
