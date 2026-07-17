package br.com.ListaDeTarefas.ToDoList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ListaDeTarefas.ToDoList.dto.RecursoDTO;
import br.com.ListaDeTarefas.ToDoList.entity.RecursoEntity;
import br.com.ListaDeTarefas.ToDoList.repository.RecursoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecursoService {
	
	private final RecursoRepository recursoRepository;
	
	public List<RecursoDTO> listar() {
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDTO::new).toList();
	}
	
	public void salvar(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
	}
	
	public RecursoDTO alterar(RecursoDTO recursoDTO) {
		RecursoEntity recursoEntity = new RecursoEntity(recursoDTO);
		return new RecursoDTO(recursoRepository.save(recursoEntity));
		
	}
	
	public void deletar(Long id) {
		RecursoEntity recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);
		
	}
	
	public RecursoDTO buscarPorId(Long id) {
		
		return new RecursoDTO(recursoRepository.findById(id).get());
	}
	
}
