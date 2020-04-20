package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelas informacoes de GravidadeInsonia.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GravidadeInsonia implements Serializable{

    private static final long serialVersionUID = -2797653853629696970L;

    private Long idGravidadeInsonia;
    private Long idPaciente;
    private Integer gravidadeInsonia;
    private Integer tipoGravidadeInsonia;
    private Integer satisfacaoPadraoSono;
    private Integer interferenciaAtividadeDiaria;
    private Integer percepcaoExterna;
    private Integer nivelPreocupacao;

    public GravidadeInsonia() {
    }

    /**
     * Obtem o valor corrente de idGravidadeInsonia.
     *
     * @return O valor corrente de idGravidadeInsonia.
     */
    public final Long getIdGravidadeInsonia() {
        return idGravidadeInsonia;
    }

    /**
     * Define um novo valor para idGravidadeInsonia.
     *
     * @param idGravidadeInsonia O novo valor para idGravidadeInsonia.
     */
    public final void setIdGravidadeInsonia(final Long idGravidadeInsonia) {
        this.idGravidadeInsonia = idGravidadeInsonia;
    }

    /**
     * Obtem o valor corrente de idPaciente.
     *
     * @return O valor corrente de idPaciente.
     */
    public final Long getIdPaciente() {
        return idPaciente;
    }

    /**
     * Define um novo valor para idPaciente.
     *
     * @param idPaciente O novo valor para idPaciente.
     */
    public final void setIdPaciente(final Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * Obtem o valor corrente de gravidadeInsonia.
     *
     * @return O valor corrente de gravidadeInsonia.
     */
    public final Integer getGravidadeInsonia() {
        return gravidadeInsonia;
    }

    /**
     * Define um novo valor para gravidadeInsonia.
     *
     * @param gravidadeInsonia O novo valor para gravidadeInsonia.
     */
    public final void setGravidadeInsonia(final Integer gravidadeInsonia) {
        this.gravidadeInsonia = gravidadeInsonia;
    }

    /**
     * Obtem o valor corrente de tipoGravidadeInsonia.
     *
     * @return O valor corrente de tipoGravidadeInsonia.
     */
    public final Integer getTipoGravidadeInsonia() {
        return tipoGravidadeInsonia;
    }

    /**
     * Define um novo valor para tipoGravidadeInsonia.
     *
     * @param tipoGravidadeInsonia O novo valor para tipoGravidadeInsonia.
     */
    public final void setTipoGravidadeInsonia(final Integer tipoGravidadeInsonia) {
        this.tipoGravidadeInsonia = tipoGravidadeInsonia;
    }

    /**
     * Obtem o valor corrente de satisfacaoPadraoSono.
     *
     * @return O valor corrente de satisfacaoPadraoSono.
     */
    public final Integer getSatisfacaoPadraoSono() {
        return satisfacaoPadraoSono;
    }

    /**
     * Define um novo valor para satisfacaoPadraoSono.
     *
     * @param satisfacaoPadraoSono O novo valor para satisfacaoPadraoSono.
     */
    public final void setSatisfacaoPadraoSono(final Integer satisfacaoPadraoSono) {
        this.satisfacaoPadraoSono = satisfacaoPadraoSono;
    }

    /**
     * Obtem o valor corrente de interferenciaAtividadeDiaria.
     *
     * @return O valor corrente de interferenciaAtividadeDiaria.
     */
    public final Integer getInterferenciaAtividadeDiaria() {
        return interferenciaAtividadeDiaria;
    }

    /**
     * Define um novo valor para interferenciaAtividadeDiaria.
     *
     * @param interferenciaAtividadeDiaria O novo valor para interferenciaAtividadeDiaria.
     */
    public final void setInterferenciaAtividadeDiaria(final Integer interferenciaAtividadeDiaria) {
        this.interferenciaAtividadeDiaria = interferenciaAtividadeDiaria;
    }

    /**
     * Obtem o valor corrente de percepcaoExterna.
     *
     * @return O valor corrente de percepcaoExterna.
     */
    public final Integer getPercepcaoExterna() {
        return percepcaoExterna;
    }

    /**
     * Define um novo valor para percepcaoExterna.
     *
     * @param percepcaoExterna O novo valor para percepcaoExterna.
     */
    public final void setPercepcaoExterna(final Integer percepcaoExterna) {
        this.percepcaoExterna = percepcaoExterna;
    }

    /**
     * Obtem o valor corrente de nivelPreocupacao.
     *
     * @return O valor corrente de nivelPreocupacao.
     */
    public final Integer getNivelPreocupacao() {
        return nivelPreocupacao;
    }

    /**
     * Define um novo valor para nivelPreocupacao.
     *
     * @param nivelPreocupacao O novo valor para nivelPreocupacao.
     */
    public final void setNivelPreocupacao(final Integer nivelPreocupacao) {
        this.nivelPreocupacao = nivelPreocupacao;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("GravidadeInsonia{");
        sb.append("idGravidadeInsonia=").append(idGravidadeInsonia);
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", gravidadeInsonia=").append(gravidadeInsonia);
        sb.append(", tipoGravidadeInsonia=").append(tipoGravidadeInsonia);
        sb.append(", satisfacaoPadraoSono=").append(satisfacaoPadraoSono);
        sb.append(", interferenciaAtividadeDiaria=").append(interferenciaAtividadeDiaria);
        sb.append(", percepcaoExterna=").append(percepcaoExterna);
        sb.append(", nivelPreocupacao=").append(nivelPreocupacao);
        sb.append('}');
        return sb.toString();
    }
}
