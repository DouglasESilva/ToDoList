package br.com.ListaDeTarefas.ToDoList.controller;

import br.com.ListaDeTarefas.ToDoList.dto.AuthenticationDTO;
import br.com.ListaDeTarefas.ToDoList.dto.UsuarioDTO;
import br.com.ListaDeTarefas.ToDoList.entity.RecursoEntity;
import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import br.com.ListaDeTarefas.ToDoList.service.AuthService;
import br.com.ListaDeTarefas.ToDoList.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok(authService.login(authenticationDTO));

    }

    @PostMapping(value = "/novoUsuario")
    public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario) {
        usuarioService.inserirNovoUsuario(novoUsuario);
    }
}
