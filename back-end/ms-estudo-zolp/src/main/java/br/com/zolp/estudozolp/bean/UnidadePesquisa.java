package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Classe responsável pelas informacoes de UnidadePesquisa.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnidadePesquisa implements Serializable{

    private static final long serialVersionUID = 1288214482724547066L;

    private Long idUnidadePesquisa;
    private String dsUnidade;
    private String siglaUnidade;
    private String telUnidade;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String investigador;
    private String coordenador;
    private String email;
    private Integer nuUnidade;

    public UnidadePesquisa() {
    }

    /**
     * Obtem o valor corrente de idUnidadePesquisa.
     *
     * @return O valor corrente de idUnidadePesquisa.
     */
    public Long getIdUnidadePesquisa() {
        return idUnidadePesquisa;
    }

    /**
     * Define um novo valor para idUnidadePesquisa.
     *
     * @param idUnidadePesquisa O novo valor para idUnidadePesquisa.
     */
    public void setIdUnidadePesquisa(final Long idUnidadePesquisa) {
        this.idUnidadePesquisa = idUnidadePesquisa;
    }

    /**
     * Obtem o valor corrente de dsUnidade.
     *
     * @return O valor corrente de dsUnidade.
     */
    public String getDsUnidade() {
        return dsUnidade;
    }

    /**
     * Define um novo valor para dsUnidade.
     *
     * @param dsUnidade O novo valor para dsUnidade.
     */
    public void setDsUnidade(final String dsUnidade) {
        this.dsUnidade = dsUnidade;
    }

    /**
     * Obtem o valor corrente de siglaUnidade.
     *
     * @return O valor corrente de siglaUnidade.
     */
    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    /**
     * Define um novo valor para siglaUnidade.
     *
     * @param siglaUnidade O novo valor para siglaUnidade.
     */
    public void setSiglaUnidade(final String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    /**
     * Obtem o valor corrente de telUnidade.
     *
     * @return O valor corrente de telUnidade.
     */
    public String getTelUnidade() {
        return telUnidade;
    }

    /**
     * Define um novo valor para telUnidade.
     *
     * @param telUnidade O novo valor para telUnidade.
     */
    public void setTelUnidade(final String telUnidade) {
        this.telUnidade = telUnidade;
    }

    /**
     * Obtem o valor corrente de endereco.
     *
     * @return O valor corrente de endereco.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define um novo valor para endereco.
     *
     * @param endereco O novo valor para endereco.
     */
    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtem o valor corrente de cidade.
     *
     * @return O valor corrente de cidade.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define um novo valor para cidade.
     *
     * @param cidade O novo valor para cidade.
     */
    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtem o valor corrente de uf.
     *
     * @return O valor corrente de uf.
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define um novo valor para uf.
     *
     * @param uf O novo valor para uf.
     */
    public void setUf(final String uf) {
        this.uf = uf;
    }

    /**
     * Obtem o valor corrente de cep.
     *
     * @return O valor corrente de cep.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define um novo valor para cep.
     *
     * @param cep O novo valor para cep.
     */
    public void setCep(final String cep) {
        this.cep = cep;
    }

    /**
     * Obtem o valor corrente de investigador.
     *
     * @return O valor corrente de investigador.
     */
    public String getInvestigador() {
        return investigador;
    }

    /**
     * Define um novo valor para investigador.
     *
     * @param investigador O novo valor para investigador.
     */
    public void setInvestigador(final String investigador) {
        this.investigador = investigador;
    }

    /**
     * Obtem o valor corrente de coordenador.
     *
     * @return O valor corrente de coordenador.
     */
    public String getCoordenador() {
        return coordenador;
    }

    /**
     * Define um novo valor para coordenador.
     *
     * @param coordenador O novo valor para coordenador.
     */
    public void setCoordenador(final String coordenador) {
        this.coordenador = coordenador;
    }

    /**
     * Obtem o valor corrente de email.
     *
     * @return O valor corrente de email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define um novo valor para email.
     *
     * @param email O novo valor para email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Obtem o valor corrente de nuUnidade.
     *
     * @return O valor corrente de nuUnidade.
     */
    public Integer getNuUnidade() {
        return nuUnidade;
    }

    /**
     * Define um novo valor para nuUnidade.
     *
     * @param nuUnidade O novo valor para nuUnidade.
     */
    public void setNuUnidade(final Integer nuUnidade) {
        this.nuUnidade = nuUnidade;
    }

    @Override
    public final String toString() {
        return "UnidadePesquisa{" +
        "idUnidadePesquisa=" + idUnidadePesquisa +
        ", dsUnidade='" + dsUnidade + '\'' +
        ", siglaUnidade='" + siglaUnidade + '\'' +
        ", telUnidade='" + telUnidade + '\'' +
        ", endereco='" + endereco + '\'' +
        ", cidade='" + cidade + '\'' +
        ", uf='" + uf + '\'' +
        ", cep='" + cep + '\'' +
        ", investigador='" + investigador + '\'' +
        ", coordenador='" + coordenador + '\'' +
        ", email='" + email + '\'' +
        ", nuUnidade=" + nuUnidade +
        '}';
}
}
