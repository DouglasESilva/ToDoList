package br.com.ListaDeTarefas.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ListaDeTarefas.ToDoList.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}
