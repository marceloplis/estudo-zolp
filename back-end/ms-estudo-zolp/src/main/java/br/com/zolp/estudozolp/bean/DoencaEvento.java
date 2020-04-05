package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Classe responsável pelas informacoes de DoencaEvento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoencaEvento implements Serializable{

    private static final long serialVersionUID = -9221770510383778092L;

    private Long idDoencaEvento;
    private String dsDoenca;
    private String siglaDoenca;

    public DoencaEvento() {
    }

    /**
     * Obtem o valor corrente de idDoencaEvento.
     *
     * @return O valor corrente de idDoencaEvento.
     */
    public Long getIdDoencaEvento() {
        return idDoencaEvento;
    }

    /**
     * Define um novo valor para idDoencaEvento.
     *
     * @param idDoencaEvento O novo valor para idDoencaEvento.
     */
    public void setIdDoencaEvento(final Long idDoencaEvento) {
        this.idDoencaEvento = idDoencaEvento;
    }

    /**
     * Obtem o valor corrente de dsDoenca.
     *
     * @return O valor corrente de dsDoenca.
     */
    public String getDsDoenca() {
        return dsDoenca;
    }

    /**
     * Define um novo valor para dsDoenca.
     *
     * @param dsDoenca O novo valor para dsDoenca.
     */
    public void setDsDoenca(final String dsDoenca) {
        this.dsDoenca = dsDoenca;
    }

    /**
     * Obtem o valor corrente de siglaDoenca.
     *
     * @return O valor corrente de siglaDoenca.
     */
    public String getSiglaDoenca() {
        return siglaDoenca;
    }

    /**
     * Define um novo valor para siglaDoenca.
     *
     * @param siglaDoenca O novo valor para siglaDoenca.
     */
    public void setSiglaDoenca(final String siglaDoenca) {
        this.siglaDoenca = siglaDoenca;
    }

    @Override
    public final String toString() {
        return "DoencaEvento{" +
            "idDoencaEvento=" + idDoencaEvento +
            ", dsDoenca='" + dsDoenca + '\'' +
            ", siglaDoenca='" + siglaDoenca + '\'' +
            '}';
    }
}
