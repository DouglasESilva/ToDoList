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

import br.com.ListaDeTarefas.ToDoList.dto.PerfilUsuarioDTO;
import br.com.ListaDeTarefas.ToDoList.service.PerfilUsuarioService;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {
	
	private final PerfilUsuarioService perfilUsuarioService;
	
	public PerfilUsuarioController(PerfilUsuarioService pUS) {
		this.perfilUsuarioService = pUS;
	}
	
	@GetMapping("/listar")
	public List<PerfilUsuarioDTO> listar() {
		List<PerfilUsuarioDTO> perfilUsuarioDTO = perfilUsuarioService.listar();
		return perfilUsuarioDTO;
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
		perfilUsuarioService.salvar(perfilUsuarioDTO);
	}
	
	@PutMapping("/alterar")
	public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
		return perfilUsuarioService.alterar(perfilUsuarioDTO);
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		perfilUsuarioService.deletar(id);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/buscarPorId/{id}")
	public PerfilUsuarioDTO buscarPorId(@PathVariable Long id) {
		return perfilUsuarioService.buscarPorId(id);
	
	}

}
