package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelas informacoes de SaidaEstudo.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaidaEstudo implements Serializable{

    private static final long serialVersionUID = -2797653853629696970L;

    private Long idSaidaEstudo;
    private Long idPaciente;
    private Date dtInclusao;
    private Integer nuVisita;
    private Date dtSaida;
    private Date dtOcorrencia;
    private Integer motivo;
    private String flEvolucaoObito;
    private String stAprovacao;
    private String assinatura;
    private Date dtAssinatura;
    private String observacao;

    public SaidaEstudo() {
    }

    /**
     * Obtem o valor corrente de idSaidaEstudo.
     *
     * @return O valor corrente de idSaidaEstudo.
     */
    public Long getIdSaidaEstudo() {
        return idSaidaEstudo;
    }

    /**
     * Define um novo valor para idSaidaEstudo.
     *
     * @param idSaidaEstudo O novo valor para idSaidaEstudo.
     */
    public void setIdSaidaEstudo(final Long idSaidaEstudo) {
        this.idSaidaEstudo = idSaidaEstudo;
    }

    /**
     * Obtem o valor corrente de idPaciente.
     *
     * @return O valor corrente de idPaciente.
     */
    public Long getIdPaciente() {
        return idPaciente;
    }

    /**
     * Define um novo valor para idPaciente.
     *
     * @param idPaciente O novo valor para idPaciente.
     */
    public void setIdPaciente(final Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * Obtem o valor corrente de dtInclusao.
     *
     * @return O valor corrente de dtInclusao.
     */
    public Date getDtInclusao() {
        return dtInclusao;
    }

    /**
     * Define um novo valor para dtInclusao.
     *
     * @param dtInclusao O novo valor para dtInclusao.
     */
    public void setDtInclusao(final Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    /**
     * Obtem o valor corrente de nuVisita.
     *
     * @return O valor corrente de nuVisita.
     */
    public Integer getNuVisita() {
        return nuVisita;
    }

    /**
     * Define um novo valor para nuVisita.
     *
     * @param nuVisita O novo valor para nuVisita.
     */
    public void setNuVisita(final Integer nuVisita) {
        this.nuVisita = nuVisita;
    }

    /**
     * Obtem o valor corrente de dtSaida.
     *
     * @return O valor corrente de dtSaida.
     */
    public Date getDtSaida() {
        return dtSaida;
    }

    /**
     * Define um novo valor para dtSaida.
     *
     * @param dtSaida O novo valor para dtSaida.
     */
    public void setDtSaida(final Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    /**
     * Obtem o valor corrente de dtOcorrencia.
     *
     * @return O valor corrente de dtOcorrencia.
     */
    public Date getDtOcorrencia() {
        return dtOcorrencia;
    }

    /**
     * Define um novo valor para dtOcorrencia.
     *
     * @param dtOcorrencia O novo valor para dtOcorrencia.
     */
    public void setDtOcorrencia(final Date dtOcorrencia) {
        this.dtOcorrencia = dtOcorrencia;
    }

    /**
     * Obtem o valor corrente de motivo.
     *
     * @return O valor corrente de motivo.
     */
    public Integer getMotivo() {
        return motivo;
    }

    /**
     * Define um novo valor para motivo.
     *
     * @param motivo O novo valor para motivo.
     */
    public void setMotivo(final Integer motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtem o valor corrente de flEvolucaoObito.
     *
     * @return O valor corrente de flEvolucaoObito.
     */
    public String getFlEvolucaoObito() {
        return flEvolucaoObito;
    }

    /**
     * Define um novo valor para flEvolucaoObito.
     *
     * @param flEvolucaoObito O novo valor para flEvolucaoObito.
     */
    public void setFlEvolucaoObito(final String flEvolucaoObito) {
        this.flEvolucaoObito = flEvolucaoObito;
    }

    /**
     * Obtem o valor corrente de stAprovacao.
     *
     * @return O valor corrente de stAprovacao.
     */
    public String getStAprovacao() {
        return stAprovacao;
    }

    /**
     * Define um novo valor para stAprovacao.
     *
     * @param stAprovacao O novo valor para stAprovacao.
     */
    public void setStAprovacao(final String stAprovacao) {
        this.stAprovacao = stAprovacao;
    }

    /**
     * Obtem o valor corrente de assinatura.
     *
     * @return O valor corrente de assinatura.
     */
    public String getAssinatura() {
        return assinatura;
    }

    /**
     * Define um novo valor para assinatura.
     *
     * @param assinatura O novo valor para assinatura.
     */
    public void setAssinatura(final String assinatura) {
        this.assinatura = assinatura;
    }

    /**
     * Obtem o valor corrente de dtAssinatura.
     *
     * @return O valor corrente de dtAssinatura.
     */
    public Date getDtAssinatura() {
        return dtAssinatura;
    }

    /**
     * Define um novo valor para dtAssinatura.
     *
     * @param dtAssinatura O novo valor para dtAssinatura.
     */
    public void setDtAssinatura(final Date dtAssinatura) {
        this.dtAssinatura = dtAssinatura;
    }

    /**
     * Obtem o valor corrente de observacao.
     *
     * @return O valor corrente de observacao.
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define um novo valor para observacao.
     *
     * @param observacao O novo valor para observacao.
     */
    public void setObservacao(final String observacao) {
        this.observacao = observacao;
    }

    @Override
    public final String toString() {
        return "SaidaEstudo{" +
            "idSaidaEstudo=" + idSaidaEstudo +
            ", idPaciente=" + idPaciente +
            ", dtInclusao=" + dtInclusao +
            ", nuVisita=" + nuVisita +
            ", dtSaida=" + dtSaida +
            ", dtOcorrencia=" + dtOcorrencia +
            ", motivo=" + motivo +
            ", flEvolucaoObito='" + flEvolucaoObito + '\'' +
            ", stAprovacao='" + stAprovacao + '\'' +
            ", assinatura='" + assinatura + '\'' +
            ", dtAssinatura=" + dtAssinatura +
            ", observacao='" + observacao + '\'' +
            '}';
    }
}
