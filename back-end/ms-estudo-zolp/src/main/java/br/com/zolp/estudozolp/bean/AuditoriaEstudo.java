package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelas informacoes de AuditoriaEstudo.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditoriaEstudo implements Serializable{

    private static final long serialVersionUID = 24685255252384L;

    private Long idAuditoriaEstudo;
    private String username;
    private Date dtModificacao;
    private String tpModificacao;
    private String dsModificacao;
    private String tpEntidade;
    private Long idPaciente;

    public AuditoriaEstudo() {
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
        return "AuditoriaEstudo{" +
            "idAuditoriaEstudo=" + idAuditoriaEstudo +
            ", username='" + username + '\'' +
            ", dtModificacao=" + dtModificacao +
            ", tpModificacao='" + tpModificacao + '\'' +
            ", dsModificacao='" + dsModificacao + '\'' +
            ", tpEntidade='" + tpEntidade + '\'' +
            ", idPaciente=" + idPaciente +
            '}';
    }
}
