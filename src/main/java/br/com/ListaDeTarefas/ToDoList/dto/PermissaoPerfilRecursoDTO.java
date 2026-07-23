package br.com.ListaDeTarefas.ToDoList.dto;


import br.com.ListaDeTarefas.ToDoList.entity.PermissaoPerfilRecursoEntity;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class PermissaoPerfilRecursoDTO {

    private Long id;

    private PerfilDTO perfil;

    private RecursoDTO recurso;


    public PermissaoPerfilRecursoDTO() {

    }

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity) {

        BeanUtils.copyProperties(permissaoPerfilRecursoEntity, this);

        if (permissaoPerfilRecursoEntity.getPerfilEntity() != null) {
            this.perfil = new PerfilDTO(permissaoPerfilRecursoEntity.getPerfilEntity());
        }

        if (permissaoPerfilRecursoEntity.getRecursoEntity() != null) {
            this.recurso = new RecursoDTO(permissaoPerfilRecursoEntity.getRecursoEntity());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PermissaoPerfilRecursoDTO that = (PermissaoPerfilRecursoDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilDTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }

    public RecursoDTO getRecurso() {
        return recurso;
    }

    public void setRecurso(RecursoDTO recurso) {
        this.recurso = recurso;
    }
}