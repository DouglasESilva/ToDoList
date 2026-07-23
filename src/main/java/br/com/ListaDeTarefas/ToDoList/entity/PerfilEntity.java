package br.com.ListaDeTarefas.ToDoList.entity;

import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.dto.PerfilDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "PERFIL")
@NoArgsConstructor
@Entity
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;

	public PerfilEntity(PerfilDTO perfilDTO) {
		BeanUtils.copyProperties(perfilDTO, this);
		
	}
}


