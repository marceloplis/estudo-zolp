package br.com.zolp.estudozolp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.persistence.Transient;

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

	// TODO Verificar a necessidade de manter o sequence generator,
	// pois na tabela ja existe o AUTO_INCREMENT
	@Id
//	@SequenceGenerator(name = "seq_doenca", sequenceName = "seq_doenca", allocationSize = 1)
//	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_doenca")
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
		return "TbDoencaEvento{" +
			"idDoencaEvento=" + idDoencaEvento +
			", dsDoenca='" + dsDoenca + '\'' +
			", siglaDoenca='" + siglaDoenca + '\'' +
			'}';
	}
}
