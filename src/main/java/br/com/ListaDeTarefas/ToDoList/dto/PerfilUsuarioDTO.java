package br.com.ListaDeTarefas.ToDoList.dto;

import jakarta.persistence.Table;
import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.entity.PerfilUsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "PERFIL_USUARIO")
public class PerfilUsuarioDTO {
	
	private Long id;
	
	private UsuarioDTO usuario;
	
	private PerfilDTO perfil;
	
	public PerfilUsuarioDTO(PerfilUsuarioEntity perfilUsuario) {
		
		BeanUtils.copyProperties(perfilUsuario, this);
		if(perfilUsuario != null && perfilUsuario.getUsuarioEntity() != null) {
			this.usuario = new UsuarioDTO(perfilUsuario.getUsuarioEntity());
		}
		
		if(perfilUsuario != null && perfilUsuario.getPerfilEntity() != null) {
			this.perfil = new PerfilDTO(perfilUsuario.getPerfilEntity());
		}
	}

}
