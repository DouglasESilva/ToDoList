package br.com.ListaDeTarefas.ToDoList.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoSituacaoUsuario {

    ATIVO ("A", "Ativo"),
    INATIVO ("I", "Inativo"),
    PENDENTE ("P", "Pendente");

    private String codigo;
    private String descricao;

    private TipoSituacaoUsuario(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonCreator
    public static  TipoSituacaoUsuario getDoValor(String codigo){
        if (codigo.equals("A")){
            return TipoSituacaoUsuario.ATIVO;
        } else if (codigo.equals("I")){
            return TipoSituacaoUsuario.INATIVO;
        }  else if (codigo.equals("P")){
            return TipoSituacaoUsuario.PENDENTE;
        }else  {
            return null;
        }
    }
}
