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

import br.com.ListaDeTarefas.ToDoList.dto.PerfilDTO;
import br.com.ListaDeTarefas.ToDoList.service.PerfilService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/perfil")
@CrossOrigin
@RequiredArgsConstructor
public class PerfilController {

	private final PerfilService perfilService;
	
	@GetMapping("/listar")
	public List<PerfilDTO> listar(){
		List<PerfilDTO> lista = perfilService.listar();
		return lista;
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody PerfilDTO perfilDTO) {
		perfilService.salvar(perfilDTO);
	}
	
	@PutMapping("/alterar")
	public PerfilDTO alterar(@RequestBody PerfilDTO perfilDTO) {
		return perfilService.alterar(perfilDTO);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {		
		perfilService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/buscarPorId/{id}")
	public PerfilDTO buscarPorId(@PathVariable Long id) {
		return perfilService.buscarPorId(id);
	}
}
