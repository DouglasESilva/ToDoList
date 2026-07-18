package br.com.ListaDeTarefas.ToDoList.entity;


import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.dto.UsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name="Usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String login;
	private String email;
	private String senha;
	
	
	public UsuarioEntity(UsuarioDTO usuarioDTO) {
		BeanUtils.copyProperties(usuarioDTO, this);
		
	}
	
}
