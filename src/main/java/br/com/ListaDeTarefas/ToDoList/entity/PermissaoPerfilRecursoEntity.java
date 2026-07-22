package br.com.ListaDeTarefas.ToDoList.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class PermissaoPerfilRecursoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfilEntity;
	
	@JoinColumn(name = "ID_RECURSO")
	private RecursoEntity recursoEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}

	public RecursoEntity getRecursoEntity() {
		return recursoEntity;
	}

	public void setRecursoEntity(RecursoEntity recursoEntity) {
		this.recursoEntity = recursoEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissaoPerfilRecursoEntity other = (PermissaoPerfilRecursoEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	public PermissaoPerfilRecursoEntity() {
		
	}

	public PermissaoPerfilRecursoEntity(Long id, PerfilEntity perfilEntity, RecursoEntity recursoEntity) {
		super();
		this.id = id;
		this.perfilEntity = perfilEntity;
		this.recursoEntity = recursoEntity;
	}
	
	
}
