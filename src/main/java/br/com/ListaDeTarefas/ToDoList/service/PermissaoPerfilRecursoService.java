package br.com.ListaDeTarefas.ToDoList.service;

import br.com.ListaDeTarefas.ToDoList.dto.PermissaoPerfilRecursoDTO;
import br.com.ListaDeTarefas.ToDoList.entity.PermissaoPerfilRecursoEntity;
import br.com.ListaDeTarefas.ToDoList.repository.PermissaoPerfilRecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoPerfilRecursoService {

    private final PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;

    public PermissaoPerfilRecursoService(PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository) {
        this.permissaoPerfilRecursoRepository = permissaoPerfilRecursoRepository;
    }

    public List<PermissaoPerfilRecursoDTO> listar() {
        List<PermissaoPerfilRecursoEntity> permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findAll();
        return permissaoPerfilRecurso.stream().map(PermissaoPerfilRecursoDTO::new).toList();
    }


    public void salvar(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
        permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
    }

    public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecursoDTO);
        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));

    }

    public void deletar(Long id) {
        PermissaoPerfilRecursoEntity perfilUsuario = permissaoPerfilRecursoRepository.findById(id).get();
        permissaoPerfilRecursoRepository.delete(perfilUsuario);

    }

    public PermissaoPerfilRecursoDTO buscarPorId(Long id) {
        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.findById(id).get());
    }
}
