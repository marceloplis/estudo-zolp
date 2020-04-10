package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe responsável pelo mapeamento da entidade TbMedicamento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbMedicamento")
public class TbMedicamento implements Serializable{

    private static final long serialVersionUID = -859240691596392099L;

    @Id
	@SequenceGenerator(name = "seq_medicamento_generator", sequenceName = "seq_medicamento", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_medicamento_generator")
    @Column(name = "idMedicamento", nullable = false)
    private Long idMedicamento;

    @Column(name = "idGrupoMedicamento", nullable = false)
    private Long idGrupoMedicamento;

    @Column(name = "dsMedicamento", nullable = false)
    private String dsMedicamento;

    public TbMedicamento() {
    }

    /**
     * Obtem o valor corrente de idMedicamento.
     *
     * @return O valor corrente de idMedicamento.
     */
    public Long getIdMedicamento() {
        return idMedicamento;
    }

    /**
     * Define um novo valor para idMedicamento.
     *
     * @param idMedicamento O novo valor para idMedicamento.
     */
    public void setIdMedicamento(final Long idMedicamento) {
        this.idMedicamento = idMedicamento;
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
     * Obtem o valor corrente de dsMedicamento.
     *
     * @return O valor corrente de dsMedicamento.
     */
    public String getDsMedicamento() {
        return dsMedicamento;
    }

    /**
     * Define um novo valor para dsMedicamento.
     *
     * @param dsMedicamento O novo valor para dsMedicamento.
     */
    public void setDsMedicamento(final String dsMedicamento) {
        this.dsMedicamento = dsMedicamento;
    }

    @Override
    public final String toString() {
        return "TbMedicamento{" +
            "idMedicamento=" + idMedicamento +
            ", idGrupoMedicamento=" + idGrupoMedicamento +
            ", dsMedicamento='" + dsMedicamento + '\'' +
            '}';
    }
}
