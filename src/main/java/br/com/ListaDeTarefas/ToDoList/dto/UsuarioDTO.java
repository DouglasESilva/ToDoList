package br.com.ListaDeTarefas.ToDoList.dto;

import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	
	private Long id;
	private String nome;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(UsuarioEntity usuarioEntity) {
		BeanUtils.copyProperties(usuarioEntity, this);
		
	}
}
