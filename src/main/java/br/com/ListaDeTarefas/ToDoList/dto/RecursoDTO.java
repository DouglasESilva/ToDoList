package br.com.ListaDeTarefas.ToDoList.dto;

import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.entity.RecursoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecursoDTO {
	
	private Long id;
	
	private String nome;
	
	private String chave;

	public RecursoDTO(RecursoEntity recursoEntity) {
			BeanUtils.copyProperties(recursoEntity, this);
	}
}
