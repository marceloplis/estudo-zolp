package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelas informacoes de Visita.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Visita implements Serializable {

    private static final long serialVersionUID = 3625853629696970L;

    private Long idVisita;
    private Long nuVisita;
    private Long idPaciente;
    private Date dtInclusao;
    private Date dtRealizacao;
    private Long assinaturaAprovador;
    private Date dtAssinaturaAprovacao;
    private String stAprovacao;

    public Visita() {
    }

    /**
     * Obtem o valor corrente de idVisita.
     *
     * @return O valor corrente de idVisita.
     */
    public final Long getIdVisita() {
        return idVisita;
    }

    /**
     * Define um novo valor para idVisita.
     *
     * @param idVisita O novo valor para idVisita.
     */
    public final void setIdVisita(final Long idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * Obtem o valor corrente de nuVisita.
     *
     * @return O valor corrente de nuVisita.
     */
    public final Long getNuVisita() {
        return nuVisita;
    }

    /**
     * Define um novo valor para nuVisita.
     *
     * @param nuVisita O novo valor para nuVisita.
     */
    public final void setNuVisita(final Long nuVisita) {
        this.nuVisita = nuVisita;
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
     * Obtem o valor corrente de dtInclusao.
     *
     * @return O valor corrente de dtInclusao.
     */
    public final Date getDtInclusao() {
        return dtInclusao;
    }

    /**
     * Define um novo valor para dtInclusao.
     *
     * @param dtInclusao O novo valor para dtInclusao.
     */
    public final void setDtInclusao(final Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    /**
     * Obtem o valor corrente de dtRealizacao.
     *
     * @return O valor corrente de dtRealizacao.
     */
    public final Date getDtRealizacao() {
        return dtRealizacao;
    }

    /**
     * Define um novo valor para dtRealizacao.
     *
     * @param dtRealizacao O novo valor para dtRealizacao.
     */
    public final void setDtRealizacao(final Date dtRealizacao) {
        this.dtRealizacao = dtRealizacao;
    }

    /**
     * Obtem o valor corrente de assinaturaAprovador.
     *
     * @return O valor corrente de assinaturaAprovador.
     */
    public final Long getAssinaturaAprovador() {
        return assinaturaAprovador;
    }

    /**
     * Define um novo valor para assinaturaAprovador.
     *
     * @param assinaturaAprovador O novo valor para assinaturaAprovador.
     */
    public final void setAssinaturaAprovador(final Long assinaturaAprovador) {
        this.assinaturaAprovador = assinaturaAprovador;
    }

    /**
     * Obtem o valor corrente de dtAssinaturaAprovacao.
     *
     * @return O valor corrente de dtAssinaturaAprovacao.
     */
    public final Date getDtAssinaturaAprovacao() {
        return dtAssinaturaAprovacao;
    }

    /**
     * Define um novo valor para dtAssinaturaAprovacao.
     *
     * @param dtAssinaturaAprovacao O novo valor para dtAssinaturaAprovacao.
     */
    public final void setDtAssinaturaAprovacao(final Date dtAssinaturaAprovacao) {
        this.dtAssinaturaAprovacao = dtAssinaturaAprovacao;
    }

    /**
     * Obtem o valor corrente de stAprovacao.
     *
     * @return O valor corrente de stAprovacao.
     */
    public final String getStAprovacao() {
        return stAprovacao;
    }

    /**
     * Define um novo valor para stAprovacao.
     *
     * @param stAprovacao O novo valor para stAprovacao.
     */
    public final void setStAprovacao(final String stAprovacao) {
        this.stAprovacao = stAprovacao;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("Visita{");
        sb.append("idVisita=").append(idVisita);
        sb.append(", nuVisita=").append(nuVisita);
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", dtInclusao=").append(dtInclusao);
        sb.append(", dtRealizacao=").append(dtRealizacao);
        sb.append(", assinaturaAprovador=").append(assinaturaAprovador);
        sb.append(", dtAssinaturaAprovacao=").append(dtAssinaturaAprovacao);
        sb.append(", stAprovacao='").append(stAprovacao).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
