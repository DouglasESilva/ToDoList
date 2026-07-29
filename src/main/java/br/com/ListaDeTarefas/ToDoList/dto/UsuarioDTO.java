package br.com.ListaDeTarefas.ToDoList.dto;

import br.com.ListaDeTarefas.ToDoList.entity.enums.TipoSituacaoUsuario;
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

	private TipoSituacaoUsuario situacao;
	

	public UsuarioDTO(UsuarioEntity usuarioEntity) {
		BeanUtils.copyProperties(usuarioEntity, this);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoSituacaoUsuario getSituacao() {
		return situacao;
	}

	public void setTipoSituacao(TipoSituacaoUsuario situacao) {
		this.situacao = situacao;
	}
}
