package br.com.ListaDeTarefas.ToDoList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import br.com.ListaDeTarefas.ToDoList.dto.UsuarioDTO;
import br.com.ListaDeTarefas.ToDoList.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
	
	
	private final UsuarioService usuarioService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody UsuarioDTO usuarioDTO) {
		String usuario = usuarioService.salvar(usuarioDTO);
		return new ResponseEntity<String>(usuario,HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<UsuarioDTO>> listarTodos() {
		List<UsuarioDTO> usuarios = usuarioService.listarTodos();
		return new ResponseEntity<List<UsuarioDTO>>(usuarios,HttpStatus.OK);
		
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<UsuarioDTO> alterar(@RequestBody UsuarioDTO usuarioDTO) {
		return new ResponseEntity<UsuarioDTO>(usuarioService.alterar(usuarioDTO), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		String usuario = usuarioService.deletar(id);
		
		return new ResponseEntity<String>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
		
		UsuarioDTO usuario = usuarioService.buscarPorId(id);
		
		return new ResponseEntity<UsuarioDTO>(usuario, HttpStatus.OK);
	}
	
}
