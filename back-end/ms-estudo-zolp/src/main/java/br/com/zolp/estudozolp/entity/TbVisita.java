package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelo mapeamento da entidade TbVisita.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "TbVisita")
public class TbVisita implements Serializable {

    private static final long serialVersionUID = 2658753629696970L;

    @Id
	@SequenceGenerator(name = "seq_visita_generator", sequenceName = "seq_visita", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita_generator")
    @Column(name = "idVisita", nullable = false)
    private Long idVisita;

    @Column(name = "nuVisita", nullable = false)
    private Long nuVisita;

    @Column(name = "idPaciente", nullable = false)
    private Long idPaciente;

    @Column(name = "dtInclusao", nullable = false)
    private Date dtInclusao;

    @Column(name = "dtRealizacao", nullable = false)
    private Date dtRealizacao;

    @Column(name = "assinaturaAprovador")
    private Long assinaturaAprovador;

    @Column(name = "dtAssinaturaAprovacao")
    private Date dtAssinaturaAprovacao;

    @Column(name = "stAprovacao")
    private String stAprovacao;

    public TbVisita() {
    }

    /**
     * Obtem o valor corrente de idVisita.
     *
     * @return O valor corrente de idVisita.
     */
    public Long getIdVisita() {
        return idVisita;
    }

    /**
     * Define um novo valor para idVisita.
     *
     * @param idVisita O novo valor para idVisita.
     */
    public void setIdVisita(final Long idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * Obtem o valor corrente de nuVisita.
     *
     * @return O valor corrente de nuVisita.
     */
    public Long getNuVisita() {
        return nuVisita;
    }

    /**
     * Define um novo valor para nuVisita.
     *
     * @param nuVisita O novo valor para nuVisita.
     */
    public void setNuVisita(final Long nuVisita) {
        this.nuVisita = nuVisita;
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
     * Obtem o valor corrente de dtRealizacao.
     *
     * @return O valor corrente de dtRealizacao.
     */
    public Date getDtRealizacao() {
        return dtRealizacao;
    }

    /**
     * Define um novo valor para dtRealizacao.
     *
     * @param dtRealizacao O novo valor para dtRealizacao.
     */
    public void setDtRealizacao(final Date dtRealizacao) {
        this.dtRealizacao = dtRealizacao;
    }

    /**
     * Obtem o valor corrente de assinaturaAprovador.
     *
     * @return O valor corrente de assinaturaAprovador.
     */
    public Long getAssinaturaAprovador() {
        return assinaturaAprovador;
    }

    /**
     * Define um novo valor para assinaturaAprovador.
     *
     * @param assinaturaAprovador O novo valor para assinaturaAprovador.
     */
    public void setAssinaturaAprovador(final Long assinaturaAprovador) {
        this.assinaturaAprovador = assinaturaAprovador;
    }

    /**
     * Obtem o valor corrente de dtAssinaturaAprovacao.
     *
     * @return O valor corrente de dtAssinaturaAprovacao.
     */
    public Date getDtAssinaturaAprovacao() {
        return dtAssinaturaAprovacao;
    }

    /**
     * Define um novo valor para dtAssinaturaAprovacao.
     *
     * @param dtAssinaturaAprovacao O novo valor para dtAssinaturaAprovacao.
     */
    public void setDtAssinaturaAprovacao(final Date dtAssinaturaAprovacao) {
        this.dtAssinaturaAprovacao = dtAssinaturaAprovacao;
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
    public  void setStAprovacao(final String stAprovacao) {
        this.stAprovacao = stAprovacao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TbVisita{");
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
