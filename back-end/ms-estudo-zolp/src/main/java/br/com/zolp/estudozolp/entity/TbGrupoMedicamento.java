package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;

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
	@SequenceGenerator(name = "seq_grpmedicamento_generator", sequenceName = "seq_grpmedicamento", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_grpmedicamento_generator")
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
