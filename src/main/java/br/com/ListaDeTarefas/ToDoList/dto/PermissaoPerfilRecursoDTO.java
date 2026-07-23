package br.com.ListaDeTarefas.ToDoList.dto;


import br.com.ListaDeTarefas.ToDoList.entity.PermissaoPerfilRecursoEntity;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class PermissaoPerfilRecursoDTO {

    private Long id;

    private PerfilDTO perfilDTO;

    private RecursoDTO recursoDTO;


    public PermissaoPerfilRecursoDTO() {

    }

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity) {

        BeanUtils.copyProperties(permissaoPerfilRecursoEntity, this);

        if (permissaoPerfilRecursoEntity != null && permissaoPerfilRecursoEntity.getPerfilEntity() != null) {
            this.perfilDTO = new PerfilDTO(permissaoPerfilRecursoEntity.getPerfilEntity());
        }

        if (permissaoPerfilRecursoEntity != null && permissaoPerfilRecursoEntity.getRecursoEntity() != null) {
            this.recursoDTO = new RecursoDTO(permissaoPerfilRecursoEntity.getRecursoEntity());
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

    public PerfilDTO getPerfilDTO() {
        return perfilDTO;
    }

    public void setPerfilDTO(PerfilDTO perfilDTO) {
        this.perfilDTO = perfilDTO;
    }

    public RecursoDTO getRecursoDTO() {
        return recursoDTO;
    }

    public void setRecursoDTO(RecursoDTO recursoDTO) {
        this.recursoDTO = recursoDTO;
    }
}
