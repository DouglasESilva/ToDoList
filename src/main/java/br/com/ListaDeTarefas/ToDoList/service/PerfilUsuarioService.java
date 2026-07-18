package br.com.ListaDeTarefas.ToDoList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ListaDeTarefas.ToDoList.dto.PerfilUsuarioDTO;
import br.com.ListaDeTarefas.ToDoList.entity.PerfilUsuarioEntity;
import br.com.ListaDeTarefas.ToDoList.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {

	
	private final PerfilUsuarioRepository perfilUsuarioRepostory;
	
	public PerfilUsuarioService(PerfilUsuarioRepository pURepostory) {
		this.perfilUsuarioRepostory = pURepostory;
	}
	
	public List<PerfilUsuarioDTO> listar() {
		List<PerfilUsuarioEntity> perfilUsuario = perfilUsuarioRepostory.findAll();
		return perfilUsuario.stream().map(PerfilUsuarioDTO::new).toList();
	}
	
	
	public void salvar(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity PerfilUsuario = new PerfilUsuarioEntity(perfilUsuario);
		perfilUsuarioRepostory.save(PerfilUsuario);
	}
	
	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuarioDTO) {
		PerfilUsuarioEntity perfilUsuario = new PerfilUsuarioEntity(perfilUsuarioDTO);
		return new PerfilUsuarioDTO(perfilUsuarioRepostory.save(perfilUsuario));
		
	}
	
	public void deletar(Long id) {
		PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepostory.findById(id).get();
		perfilUsuarioRepostory.delete(perfilUsuario);
		
	}
	
	public PerfilUsuarioDTO buscarPorId(Long id) {
		return new PerfilUsuarioDTO(perfilUsuarioRepostory.findById(id).get());
	}
	
}
