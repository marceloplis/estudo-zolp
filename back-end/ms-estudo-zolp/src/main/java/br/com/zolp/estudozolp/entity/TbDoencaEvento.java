package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe responsável pelo mapeamento da entidade TbDoencaEvento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbDoencaEvento")
public class TbDoencaEvento implements Serializable{

    private static final long serialVersionUID = -9221770510383778092L;

    @Id
	@SequenceGenerator(name = "seq_doenca_generator", sequenceName = "seq_doenca", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_doenca_generator")
    @Column(name = "idDoencaEvento", nullable = false)
    private Long idDoencaEvento;

    @Column(name = "dsDoenca", nullable = false)
    private String dsDoenca;

    @Column(name = "siglaDoenca")
    private String siglaDoenca;

    public TbDoencaEvento() {
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
        final StringBuilder sb = new StringBuilder("TbDoencaEvento{");
        sb.append("idDoencaEvento=").append(idDoencaEvento);
        sb.append(", dsDoenca='").append(dsDoenca).append('\'');
        sb.append(", siglaDoenca='").append(siglaDoenca).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
