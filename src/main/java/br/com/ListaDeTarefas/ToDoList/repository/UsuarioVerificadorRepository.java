package br.com.ListaDeTarefas.ToDoList.repository;

import br.com.ListaDeTarefas.ToDoList.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {
}
