package br.com.ListaDeTarefas.ToDoList.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ListaDeTarefas.ToDoList.dto.RecursoDTO;
import br.com.ListaDeTarefas.ToDoList.service.RecursoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/recurso")
@CrossOrigin
@RequiredArgsConstructor
public class RecursoController {
	
	
	private final RecursoService recursoService;
	
	
	@GetMapping("/listar")
	public List<RecursoDTO> listar() {
		List<RecursoDTO> recursos = recursoService.listar();
		return recursos;
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody RecursoDTO recurso) {
		recursoService.salvar(recurso);
	}
	
	@PutMapping("/alterar")
	public RecursoDTO alterar(@RequestBody RecursoDTO recursoDTO) {
		return recursoService.alterar(recursoDTO);
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		recursoService.deletar(id);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/buscarPorId/{id}")
	public RecursoDTO buscarPorId(@PathVariable Long id) {
		return recursoService.buscarPorId(id);
	
	}
}
	
