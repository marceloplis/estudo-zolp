package br.com.zolp.estudozolp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe responsável pelo mapeamento da entidade TbGrupoMedicamento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbGrupoMedicamento")
public class TbGrupoMedicamento implements Serializable{

	private static final long serialVersionUID = -1336973835722435282L;

	@Id
//	@SequenceGenerator(name = "seq_grpmedicamento", sequenceName = "seq_grpmedicamento", allocationSize = 1)
//	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_grpmedicamento")
	@Column(name = "idGrupoMedicamento", nullable = false)
	private Long idGrupoMedicamento;
	
	@Column(name = "dsGrupoMedicamento", nullable = false)
	private String dsGrupoMedicamento;

	public TbGrupoMedicamento() {
	}

	/**
	 * Obtem o valor corrente de idGrupoMedicamento.
	 *
	 * @return O valor corrente de idGrupoMedicamento.
	 */
	public Long getIdGrupoMedicamento() {
		return idGrupoMedicamento;
	}

	/**
	 * Define um novo valor para idGrupoMedicamento.
	 *
	 * @param idGrupoMedicamento O novo valor para idGrupoMedicamento.
	 */
	public void setIdGrupoMedicamento(final Long idGrupoMedicamento) {
		this.idGrupoMedicamento = idGrupoMedicamento;
	}

	/**
	 * Obtem o valor corrente de dsGrupoMedicamento.
	 *
	 * @return O valor corrente de dsGrupoMedicamento.
	 */
	public String getDsGrupoMedicamento() {
		return dsGrupoMedicamento;
	}

	/**
	 * Define um novo valor para dsGrupoMedicamento.
	 *
	 * @param dsGrupoMedicamento O novo valor para dsGrupoMedicamento.
	 */
	public void setDsGrupoMedicamento(final String dsGrupoMedicamento) {
		this.dsGrupoMedicamento = dsGrupoMedicamento;
	}

	@Override
	public final String toString() {
		return "TbGrupoMedicamento{" +
			"idGrupoMedicamento=" + idGrupoMedicamento +
			", dsGrupoMedicamento='" + dsGrupoMedicamento + '\'' +
			'}';
	}
}
