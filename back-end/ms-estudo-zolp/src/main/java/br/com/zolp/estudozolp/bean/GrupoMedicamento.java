package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Classe responsável pelas informacoes de GrupoMedicamento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrupoMedicamento implements Serializable{

    private static final long serialVersionUID = -1336973835722435282L;

    private Long idGrupoMedicamento;
    private String dsGrupoMedicamento;

    public GrupoMedicamento() {
    }

    /**
     * Obtem o valor corrente de idGrupoMedicamento.
     *
     * @return O valor corrente de idGrupoMedicamento.
     */
    public Long getIdGrupoMedicamento() {
        return idGrupoMedicamento;
    }

    /**
     * Define um novo valor para idGrupoMedicamento.
     *
     * @param idGrupoMedicamento O novo valor para idGrupoMedicamento.
     */
    public void setIdGrupoMedicamento(final Long idGrupoMedicamento) {
        this.idGrupoMedicamento = idGrupoMedicamento;
    }

    /**
     * Obtem o valor corrente de dsGrupoMedicamento.
     *
     * @return O valor corrente de dsGrupoMedicamento.
     */
    public String getDsGrupoMedicamento() {
        return dsGrupoMedicamento;
    }

    /**
     * Define um novo valor para dsGrupoMedicamento.
     *
     * @param dsGrupoMedicamento O novo valor para dsGrupoMedicamento.
     */
    public void setDsGrupoMedicamento(final String dsGrupoMedicamento) {
        this.dsGrupoMedicamento = dsGrupoMedicamento;
    }

    @Override
    public final String toString() {
        return "GrupoMedicamento{" +
            "idGrupoMedicamento=" + idGrupoMedicamento +
            ", dsGrupoMedicamento='" + dsGrupoMedicamento + '\'' +
            '}';
    }
}
