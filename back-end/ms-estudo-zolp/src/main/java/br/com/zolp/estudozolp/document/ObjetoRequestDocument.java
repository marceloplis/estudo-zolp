package br.com.zolp.estudozolp.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Classe responsável por efetuar o mapeamento das informações de request.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Objeto responsável pelo request.")
public class ObjetoRequestDocument implements Serializable {

    private static final long serialVersionUID = 215462731421549187L;

    @ApiModelProperty(notes = "Código de algo.")
    private Long id;

    @ApiModelProperty(notes = "Descricao de algo.")
    private String nome;

    public ObjetoRequestDocument() { }

    public final Long getId() {
        return id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getNome() {
        return nome;
    }

    public final void setNome(final String nome) {
        this.nome = nome;
    }

    @Override
    public final String toString() {
        return "ObjetoRequestDocument{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            '}';
    }
}
