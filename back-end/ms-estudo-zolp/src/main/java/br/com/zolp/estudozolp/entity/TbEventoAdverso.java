package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelo mapeamento da entidade TbEventoAdverso.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "TbEventoAdverso")
public class TbEventoAdverso implements Serializable{

    @Id
	@SequenceGenerator(name = "seq_evento_generator", sequenceName = "seq_evento", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_evento_generator")
    @Column(name = "idEventoAdverso", nullable = false)
    private Long idEventoAdverso;

    @Column(name = "idDoenca", nullable = false)
    private Long idDoenca;

    @Column(name = "idPaciente", nullable = false)
    private Long idPaciente;

    @Column(name = "dtInclusao", nullable = false)
    private Date dtInclusao;

    @Column(name = "dtInicio")
    private Date dtInicio;

    @Column(name = "dtFim")
    private Date dtFim;

    @Column(name = "PER_E01")
    private String PER_E01;

    @Column(name = "PER_E02")
    private String PER_E02;

    @Column(name = "PER_E03")
    private String PER_E03;

    @Column(name = "PER_E04")
    private String PER_E04;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "stAprovacao")
    private String stAprovacao;

    @Column(name = "assinatura")
    private String assinatura;

    @Column(name = "dtAssinatura")
    private Date dtAssinatura;

    @Column(name = "nuVisita")
    private Integer nuVisita;

    public TbEventoAdverso() {
    }

    /**
     * Obtem o valor corrente de idEventoAdverso.
     *
     * @return O valor corrente de idEventoAdverso.
     */
    public Long getIdEventoAdverso() {
        return idEventoAdverso;
    }

    /**
     * Define um novo valor para idEventoAdverso.
     *
     * @param idEventoAdverso O novo valor para idEventoAdverso.
     */
    public void setIdEventoAdverso(final Long idEventoAdverso) {
        this.idEventoAdverso = idEventoAdverso;
    }

    /**
     * Obtem o valor corrente de idDoenca.
     *
     * @return O valor corrente de idDoenca.
     */
    public Long getIdDoenca() {
        return idDoenca;
    }

    /**
     * Define um novo valor para idDoenca.
     *
     * @param idDoenca O novo valor para idDoenca.
     */
    public void setIdDoenca(final Long idDoenca) {
        this.idDoenca = idDoenca;
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
     * Obtem o valor corrente de dtInicio.
     *
     * @return O valor corrente de dtInicio.
     */
    public Date getDtInicio() {
        return dtInicio;
    }

    /**
     * Define um novo valor para dtInicio.
     *
     * @param dtInicio O novo valor para dtInicio.
     */
    public void setDtInicio(final Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * Obtem o valor corrente de dtFim.
     *
     * @return O valor corrente de dtFim.
     */
    public Date getDtFim() {
        return dtFim;
    }

    /**
     * Define um novo valor para dtFim.
     *
     * @param dtFim O novo valor para dtFim.
     */
    public void setDtFim(final Date dtFim) {
        this.dtFim = dtFim;
    }

    /**
     * Obtem o valor corrente de PER_E01.
     *
     * @return O valor corrente de PER_E01.
     */
    public String getPER_E01() {
        return PER_E01;
    }

    /**
     * Define um novo valor para PER_E01.
     *
     * @param PER_E01 O novo valor para PER_E01.
     */
    public void setPER_E01(final String PER_E01) {
        this.PER_E01 = PER_E01;
    }

    /**
     * Obtem o valor corrente de PER_E02.
     *
     * @return O valor corrente de PER_E02.
     */
    public String getPER_E02() {
        return PER_E02;
    }

    /**
     * Define um novo valor para PER_E02.
     *
     * @param PER_E02 O novo valor para PER_E02.
     */
    public void setPER_E02(final String PER_E02) {
        this.PER_E02 = PER_E02;
    }

    /**
     * Obtem o valor corrente de PER_E03.
     *
     * @return O valor corrente de PER_E03.
     */
    public String getPER_E03() {
        return PER_E03;
    }

    /**
     * Define um novo valor para PER_E03.
     *
     * @param PER_E03 O novo valor para PER_E03.
     */
    public void setPER_E03(final String PER_E03) {
        this.PER_E03 = PER_E03;
    }

    /**
     * Obtem o valor corrente de PER_E04.
     *
     * @return O valor corrente de PER_E04.
     */
    public String getPER_E04() {
        return PER_E04;
    }

    /**
     * Define um novo valor para PER_E04.
     *
     * @param PER_E04 O novo valor para PER_E04.
     */
    public void setPER_E04(final String PER_E04) {
        this.PER_E04 = PER_E04;
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

    @Override
    public final String toString() {
        return "TbEventoAdverso{" +
            "idEventoAdverso=" + idEventoAdverso +
            ", idDoenca=" + idDoenca +
            ", idPaciente=" + idPaciente +
            ", dtInclusao=" + dtInclusao +
            ", dtInicio=" + dtInicio +
            ", dtFim=" + dtFim +
            ", PER_E01='" + PER_E01 + '\'' +
            ", PER_E02='" + PER_E02 + '\'' +
            ", PER_E03='" + PER_E03 + '\'' +
            ", PER_E04='" + PER_E04 + '\'' +
            ", observacao='" + observacao + '\'' +
            ", stAprovacao='" + stAprovacao + '\'' +
            ", assinatura='" + assinatura + '\'' +
            ", dtAssinatura=" + dtAssinatura +
            ", nuVisita=" + nuVisita +
            '}';
    }
}
