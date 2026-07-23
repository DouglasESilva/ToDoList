package br.com.ListaDeTarefas.ToDoList.controller;

import br.com.ListaDeTarefas.ToDoList.dto.PermissaoPerfilRecursoDTO;
import br.com.ListaDeTarefas.ToDoList.service.PermissaoPerfilRecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/permissao-perfil-recurso")
@CrossOrigin
public class PermissaoPerfilRecursoController {

    private final PermissaoPerfilRecursoService permissaoPerfilRecursoService;

    public PermissaoPerfilRecursoController(PermissaoPerfilRecursoService permissaoPerfilRecursoService) {
        this.permissaoPerfilRecursoService = permissaoPerfilRecursoService;
    }

    @GetMapping("/listar")
    public List<PermissaoPerfilRecursoDTO> listar() {
        List<PermissaoPerfilRecursoDTO> perfilUsuarioDTO = permissaoPerfilRecursoService.listar();
        return perfilUsuarioDTO;
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        permissaoPerfilRecursoService.salvar(permissaoPerfilRecursoDTO);
    }

    @PutMapping("/alterar")
    public PermissaoPerfilRecursoDTO alterar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        return permissaoPerfilRecursoService.alterar(permissaoPerfilRecursoDTO);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        permissaoPerfilRecursoService.deletar(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/buscarPorId/{id}")
    public PermissaoPerfilRecursoDTO buscarPorId(@PathVariable Long id) {
        return permissaoPerfilRecursoService.buscarPorId(id);

    }
}
