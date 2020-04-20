package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Classe responsável pelo mapeamento da entidade TbUnidadePesquisa.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbUnidadePesquisa")
public class TbUnidadePesquisa implements Serializable{

    private static final long serialVersionUID = 1288214482724547066L;

    @Id
	@SequenceGenerator(name = "seq_unidade_generator", sequenceName = "seq_unidade", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_unidade_generator")
    @Column(name = "idUnidadePesquisa", nullable = false)
    private Long idUnidadePesquisa;

    @Column(name = "dsUnidade", nullable = false)
    private String dsUnidade;

    @Column(name = "siglaUnidade")
    private String siglaUnidade;

    @Column(name = "telUnidade")
    private String telUnidade;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cep")
    private String cep;

    @Column(name = "investigador")
    private String investigador;

    @Column(name = "coordenador")
    private String coordenador;

    @Column(name = "email")
    private String email;

    @Column(name = "nuUnidade")
    private Integer nuUnidade;

    public TbUnidadePesquisa() {
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
        final StringBuilder sb = new StringBuilder("TbUnidadePesquisa{");
        sb.append("idUnidadePesquisa=").append(idUnidadePesquisa);
        sb.append(", dsUnidade='").append(dsUnidade).append('\'');
        sb.append(", siglaUnidade='").append(siglaUnidade).append('\'');
        sb.append(", telUnidade='").append(telUnidade).append('\'');
        sb.append(", endereco='").append(endereco).append('\'');
        sb.append(", cidade='").append(cidade).append('\'');
        sb.append(", uf='").append(uf).append('\'');
        sb.append(", cep='").append(cep).append('\'');
        sb.append(", investigador='").append(investigador).append('\'');
        sb.append(", coordenador='").append(coordenador).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", nuUnidade=").append(nuUnidade);
        sb.append('}');
        return sb.toString();
    }
}
