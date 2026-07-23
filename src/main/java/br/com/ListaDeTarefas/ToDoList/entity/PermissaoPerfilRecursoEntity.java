package br.com.ListaDeTarefas.ToDoList.entity;

import java.util.Objects;

import br.com.ListaDeTarefas.ToDoList.dto.PerfilDTO;
import br.com.ListaDeTarefas.ToDoList.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
public class PermissaoPerfilRecursoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfilEntity;

	@ManyToOne
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

	public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {

		BeanUtils.copyProperties(permissaoPerfilRecursoDTO, this);

		if (permissaoPerfilRecursoDTO != null && permissaoPerfilRecursoDTO.getPerfilDTO() != null) {
			this.perfilEntity = new PerfilEntity(permissaoPerfilRecursoDTO.getPerfilDTO());
		}

		if (permissaoPerfilRecursoDTO != null && permissaoPerfilRecursoDTO.getRecursoDTO() != null) {
			this.recursoEntity = new RecursoEntity(permissaoPerfilRecursoDTO.getRecursoDTO());
		}
	}
	
	
}
