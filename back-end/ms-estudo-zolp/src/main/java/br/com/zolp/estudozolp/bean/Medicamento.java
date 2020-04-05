package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Classe responsável pelas informacoes de Medicamento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Medicamento implements Serializable{

    private static final long serialVersionUID = -859240691596392099L;

    private Long idMedicamento;
    private Long idGrupoMedicamento;
    private String dsMedicamento;

    public Medicamento() {
    }

    /**
     * Obtem o valor corrente de idMedicamento.
     *
     * @return O valor corrente de idMedicamento.
     */
    public Long getIdMedicamento() {
        return idMedicamento;
    }

    /**
     * Define um novo valor para idMedicamento.
     *
     * @param idMedicamento O novo valor para idMedicamento.
     */
    public void setIdMedicamento(final Long idMedicamento) {
        this.idMedicamento = idMedicamento;
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
     * Obtem o valor corrente de dsMedicamento.
     *
     * @return O valor corrente de dsMedicamento.
     */
    public String getDsMedicamento() {
        return dsMedicamento;
    }

    /**
     * Define um novo valor para dsMedicamento.
     *
     * @param dsMedicamento O novo valor para dsMedicamento.
     */
    public void setDsMedicamento(final String dsMedicamento) {
        this.dsMedicamento = dsMedicamento;
    }

    @Override
    public final String toString() {
        return "Medicamento{" +
            "idMedicamento=" + idMedicamento +
            ", idGrupoMedicamento=" + idGrupoMedicamento +
            ", dsMedicamento='" + dsMedicamento + '\'' +
            '}';
    }
}
