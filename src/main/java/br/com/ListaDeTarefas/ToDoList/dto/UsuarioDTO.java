package br.com.ListaDeTarefas.ToDoList.dto;

import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

	
	private Long id;
	private String nome;
	private String login;
	private String email;
	private String senha;
	

	public UsuarioDTO(UsuarioEntity usuarioEntity) {
		BeanUtils.copyProperties(usuarioEntity, this);
		
	}
}
