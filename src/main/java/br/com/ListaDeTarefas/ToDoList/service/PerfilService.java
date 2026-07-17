package br.com.ListaDeTarefas.ToDoList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ListaDeTarefas.ToDoList.dto.PerfilDTO;
import br.com.ListaDeTarefas.ToDoList.entity.PerfilEntity;
import br.com.ListaDeTarefas.ToDoList.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerfilService {

	private final PerfilRepository perfilRepository;
	
	public List<PerfilDTO> listar(){
		List<PerfilEntity> lista = perfilRepository.findAll();
		return lista.stream().map(PerfilDTO::new).toList();
	}
	
	public void salvar(PerfilDTO perfilDTO) {
		PerfilEntity perfilEntity = new PerfilEntity(perfilDTO);
		perfilRepository.save(perfilEntity);
	}
	
	public PerfilDTO alterar(PerfilDTO perfilDTO) {
		PerfilEntity perfilEntity = new PerfilEntity(perfilDTO);
		return new PerfilDTO(perfilRepository.save(perfilEntity));
	}
	
	public void deletar(Long id) {		
		perfilRepository.deleteById(id);
	}
	
	public PerfilDTO buscarPorId(Long id) {
		return new PerfilDTO(perfilRepository.findById(id).get());
	}
}
