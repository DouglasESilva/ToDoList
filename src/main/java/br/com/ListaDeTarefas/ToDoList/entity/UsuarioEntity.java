package br.com.ListaDeTarefas.ToDoList.entity;


import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import br.com.ListaDeTarefas.ToDoList.dto.UsuarioDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name="USUARIO")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	
	
	public UsuarioEntity(UsuarioDTO usuarioDTO) {
		BeanUtils.copyProperties(usuarioDTO, this);
		
	}
	
}
