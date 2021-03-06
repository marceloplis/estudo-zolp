package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelo mapeamento da entidade TbAuditoriaEstudo.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbAuditoriaEstudo")
public class TbAuditoriaEstudo implements Serializable{

    private static final long serialVersionUID = 24685255252384L;

    @Id
	@SequenceGenerator(name = "seq_logauditoria_generator", sequenceName = "seq_logauditoria", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_logauditoria_generator")
    @Column(name = "idAuditoriaEstudo", nullable = false)
    private Long idAuditoriaEstudo;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "dtModificacao", nullable = false)
    private Date dtModificacao;

    @Column(name = "tpModificacao", nullable = false)
    private String tpModificacao;

    @Column(name = "dsModificacao")
    private String dsModificacao;

    @Column(name = "tpEntidade", nullable = false)
    private String tpEntidade;

    @Column(name = "idPaciente", nullable = false)
    private Long idPaciente;

    public TbAuditoriaEstudo() {
    }

    /**
     * Obtem o valor corrente de idAuditoriaEstudo.
     *
     * @return O valor corrente de idAuditoriaEstudo.
     */
    public Long getIdAuditoriaEstudo() {
        return idAuditoriaEstudo;
    }

    /**
     * Define um novo valor para idAuditoriaEstudo.
     *
     * @param idAuditoriaEstudo O novo valor para idAuditoriaEstudo.
     */
    public void setIdAuditoriaEstudo(final Long idAuditoriaEstudo) {
        this.idAuditoriaEstudo = idAuditoriaEstudo;
    }

    /**
     * Obtem o valor corrente de username.
     *
     * @return O valor corrente de username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define um novo valor para username.
     *
     * @param username O novo valor para username.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Obtem o valor corrente de dtModificacao.
     *
     * @return O valor corrente de dtModificacao.
     */
    public Date getDtModificacao() {
        return dtModificacao;
    }

    /**
     * Define um novo valor para dtModificacao.
     *
     * @param dtModificacao O novo valor para dtModificacao.
     */
    public void setDtModificacao(final Date dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    /**
     * Obtem o valor corrente de tpModificacao.
     *
     * @return O valor corrente de tpModificacao.
     */
    public String getTpModificacao() {
        return tpModificacao;
    }

    /**
     * Define um novo valor para tpModificacao.
     *
     * @param tpModificacao O novo valor para tpModificacao.
     */
    public void setTpModificacao(final String tpModificacao) {
        this.tpModificacao = tpModificacao;
    }

    /**
     * Obtem o valor corrente de dsModificacao.
     *
     * @return O valor corrente de dsModificacao.
     */
    public String getDsModificacao() {
        return dsModificacao;
    }

    /**
     * Define um novo valor para dsModificacao.
     *
     * @param dsModificacao O novo valor para dsModificacao.
     */
    public void setDsModificacao(final String dsModificacao) {
        this.dsModificacao = dsModificacao;
    }

    /**
     * Obtem o valor corrente de tpEntidade.
     *
     * @return O valor corrente de tpEntidade.
     */
    public String getTpEntidade() {
        return tpEntidade;
    }

    /**
     * Define um novo valor para tpEntidade.
     *
     * @param tpEntidade O novo valor para tpEntidade.
     */
    public void setTpEntidade(final String tpEntidade) {
        this.tpEntidade = tpEntidade;
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

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("TbAuditoriaEstudo{");
        sb.append("idAuditoriaEstudo=").append(idAuditoriaEstudo);
        sb.append(", username='").append(username).append('\'');
        sb.append(", dtModificacao=").append(dtModificacao);
        sb.append(", tpModificacao='").append(tpModificacao).append('\'');
        sb.append(", dsModificacao='").append(dsModificacao).append('\'');
        sb.append(", tpEntidade='").append(tpEntidade).append('\'');
        sb.append(", idPaciente=").append(idPaciente);
        sb.append('}');
        return sb.toString();
    }
}
