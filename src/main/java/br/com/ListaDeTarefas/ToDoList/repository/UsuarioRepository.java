package br.com.ListaDeTarefas.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
