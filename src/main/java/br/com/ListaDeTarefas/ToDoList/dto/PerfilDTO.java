package br.com.ListaDeTarefas.ToDoList.dto;

import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.entity.PerfilEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {

	private Long id;
	
	private String descricao;

	public PerfilDTO(PerfilEntity perfilEntity) {
		BeanUtils.copyProperties(perfilEntity, this);
		
	}
	
}
