package br.com.ListaDeTarefas.ToDoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ListaDeTarefas.ToDoList.dto.UsuarioDTO;
import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import br.com.ListaDeTarefas.ToDoList.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
 // CRUD
	
	private final UsuarioRepository usuarioRepository;


	private final PasswordEncoder encoder;
	
	
	public String salvar(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
		usuarioEntity.setSenha(encoder.encode(usuarioDTO.getSenha()));
		usuarioRepository.save(usuarioEntity);
		return "Usuario Salvo Com Sucesso";
	}
	
	public List<UsuarioDTO> listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
		
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
		usuarioEntity.setSenha(encoder.encode(usuarioDTO.getSenha()));
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
		
	}
	
	public String deletar(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
		
		return "Usuario Deletado Com Sucesso";
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
	
	
	
}
