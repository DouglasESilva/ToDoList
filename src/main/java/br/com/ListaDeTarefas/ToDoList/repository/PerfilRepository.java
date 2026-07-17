package br.com.ListaDeTarefas.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ListaDeTarefas.ToDoList.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long>{

}
