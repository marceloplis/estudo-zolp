package br.com.zolp.estudozolp.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Classe responsável por efetuar o mapeamento das informações de response.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Objeto responsável pelo response.")
public class ObjetoResponseDocument implements Serializable {

    private static final long serialVersionUID = 326582784214857854L;

    @ApiModelProperty(notes = "Retorno.")
    private String retorno;

    public ObjetoResponseDocument() {
    }

    public final String getRetorno() {
        return retorno;
    }

    public final void setRetorno(final String retorno) {
        this.retorno = retorno;
    }

    @Override
    public final String toString() {
        return "ObjetoResponseDocument{" +
            "retorno='" + retorno + '\'' +
            '}';
    }
}
