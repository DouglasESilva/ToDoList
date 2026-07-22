package br.com.ListaDeTarefas.ToDoList.entity;

import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.dto.PerfilUsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PERFIL_USUARIO")
public class PerfilUsuarioEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuarioEntity;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfilEntity;
	
	public PerfilUsuarioEntity(PerfilUsuarioDTO perfilUsuario) {
		
		BeanUtils.copyProperties(perfilUsuario, this);
		
		if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuarioEntity = new UsuarioEntity(perfilUsuario.getUsuario());
		}
		
		if(perfilUsuario != null && perfilUsuario.getPerfil() != null) {
			this.perfilEntity = new PerfilEntity(perfilUsuario.getPerfil());
		}
	}
	
}
