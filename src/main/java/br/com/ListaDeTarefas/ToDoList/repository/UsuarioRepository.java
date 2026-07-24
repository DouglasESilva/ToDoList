package br.com.ListaDeTarefas.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    Optional<UsuarioEntity> findByLogin(String login);

}
