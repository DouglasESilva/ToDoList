package br.com.ListaDeTarefas.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ListaDeTarefas.ToDoList.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long>{

}
