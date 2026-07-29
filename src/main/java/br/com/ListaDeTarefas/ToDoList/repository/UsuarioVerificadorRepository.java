package br.com.ListaDeTarefas.ToDoList.repository;

import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import br.com.ListaDeTarefas.ToDoList.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {

    Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
