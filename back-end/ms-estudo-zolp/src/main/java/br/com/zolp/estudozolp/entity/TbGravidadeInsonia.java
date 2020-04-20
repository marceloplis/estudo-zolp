package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelo mapeamento da entidade TbGravidadeInsonia.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "TbGravidadeInsonia")
public class TbGravidadeInsonia implements Serializable{

    private static final long serialVersionUID = 53648753629696970L;

    @Id
	@SequenceGenerator(name = "seq_grav_insonia_generator", sequenceName = "seq_grav_insonia", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_grav_insonia_generator")
    @Column(name = "idGravidadeInsonia", nullable = false)
    private Long idGravidadeInsonia;

    @Column(name = "idPaciente", nullable = false)
    private Long idPaciente;

    /**
     * Gravidade da insonia (1 - Dificuladade Pegar Sono / 2 - Dificuldade Manter Sono / 3 - Despertar Muito Cedo)
      */
    @Column(name = "gravidadeInsonia")
    private Integer gravidadeInsonia;

    /**
     * Tipo de Gravidade da insonia (1 - Nenhuma / 2 - Leve / 3 - Moderada / 4 - Grave / 5 - Muito Grave)
     */
    @Column(name = "tipoGravidadeInsonia")
    private Integer tipoGravidadeInsonia;

    /**
     * Satisfacao com o padrao de sono (1 - Muito Satisfeito / 2 - Satisfeito / 3 - Indiferente / 4 - Insatisfeito / 5 - Muito Insatisfeito)
     */
    @Column(name = "satisfacaoPadraoSono", nullable = false)
    private Integer satisfacaoPadraoSono;

    /**
     * Interferencia dtividade diaria ( 1 - Nao Interfere / 2 - Interfere um Pouco / 3 - Interfere de algum modo / 4 - Interfere Muito / 5 - Interfere Extremamente)
     */
    @Column(name = "interferenciaAtividadeDiaria", nullable = false)
    private Integer interferenciaAtividadeDiaria;

    /**
     * Percepcao Externa ( 1 - Nao Percebem / 2 - Percebem um Pouco / 3 - Percebem de algum modo / 4 - Percebem Muito / 5 - Percebem Extremamente )
     */
    @Column(name = "percepcaoExterna", nullable = false)
    private Integer percepcaoExterna;

    /**
     * Nivel de Preocupacao ( 1 - Nao estou preocupado / 2 - Um pouco preocupado / 3 - De algum modo preocupado / 4 - Muito preocupado / 5 - Extremamente preocupado)
     */
    @Column(name = "nivelPreocupacao", nullable = false)
    private Integer nivelPreocupacao;

    public TbGravidadeInsonia() {
    }

    /**
     * Obtem o valor corrente de idGravidadeInsonia.
     *
     * @return O valor corrente de idGravidadeInsonia.
     */
    public Long getIdGravidadeInsonia() {
        return idGravidadeInsonia;
    }

    /**
     * Define um novo valor para idGravidadeInsonia.
     *
     * @param idGravidadeInsonia O novo valor para idGravidadeInsonia.
     */
    public void setIdGravidadeInsonia(final Long idGravidadeInsonia) {
        this.idGravidadeInsonia = idGravidadeInsonia;
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

    /**
     * Obtem o valor corrente de gravidadeInsonia.
     *
     * @return O valor corrente de gravidadeInsonia.
     */
    public Integer getGravidadeInsonia() {
        return gravidadeInsonia;
    }

    /**
     * Define um novo valor para gravidadeInsonia.
     *
     * @param gravidadeInsonia O novo valor para gravidadeInsonia.
     */
    public void setGravidadeInsonia(final Integer gravidadeInsonia) {
        this.gravidadeInsonia = gravidadeInsonia;
    }

    /**
     * Obtem o valor corrente de tipoGravidadeInsonia.
     *
     * @return O valor corrente de tipoGravidadeInsonia.
     */
    public Integer getTipoGravidadeInsonia() {
        return tipoGravidadeInsonia;
    }

    /**
     * Define um novo valor para tipoGravidadeInsonia.
     *
     * @param tipoGravidadeInsonia O novo valor para tipoGravidadeInsonia.
     */
    public void setTipoGravidadeInsonia(final Integer tipoGravidadeInsonia) {
        this.tipoGravidadeInsonia = tipoGravidadeInsonia;
    }

    /**
     * Obtem o valor corrente de satisfacaoPadraoSono.
     *
     * @return O valor corrente de satisfacaoPadraoSono.
     */
    public Integer getSatisfacaoPadraoSono() {
        return satisfacaoPadraoSono;
    }

    /**
     * Define um novo valor para satisfacaoPadraoSono.
     *
     * @param satisfacaoPadraoSono O novo valor para satisfacaoPadraoSono.
     */
    public void setSatisfacaoPadraoSono(final Integer satisfacaoPadraoSono) {
        this.satisfacaoPadraoSono = satisfacaoPadraoSono;
    }

    /**
     * Obtem o valor corrente de interferenciaAtividadeDiaria.
     *
     * @return O valor corrente de interferenciaAtividadeDiaria.
     */
    public Integer getInterferenciaAtividadeDiaria() {
        return interferenciaAtividadeDiaria;
    }

    /**
     * Define um novo valor para interferenciaAtividadeDiaria.
     *
     * @param interferenciaAtividadeDiaria O novo valor para interferenciaAtividadeDiaria.
     */
    public void setInterferenciaAtividadeDiaria(final Integer interferenciaAtividadeDiaria) {
        this.interferenciaAtividadeDiaria = interferenciaAtividadeDiaria;
    }

    /**
     * Obtem o valor corrente de percepcaoExterna.
     *
     * @return O valor corrente de percepcaoExterna.
     */
    public Integer getPercepcaoExterna() {
        return percepcaoExterna;
    }

    /**
     * Define um novo valor para percepcaoExterna.
     *
     * @param percepcaoExterna O novo valor para percepcaoExterna.
     */
    public void setPercepcaoExterna(final Integer percepcaoExterna) {
        this.percepcaoExterna = percepcaoExterna;
    }

    /**
     * Obtem o valor corrente de nivelPreocupacao.
     *
     * @return O valor corrente de nivelPreocupacao.
     */
    public Integer getNivelPreocupacao() {
        return nivelPreocupacao;
    }

    /**
     * Define um novo valor para nivelPreocupacao.
     *
     * @param nivelPreocupacao O novo valor para nivelPreocupacao.
     */
    public void setNivelPreocupacao(final Integer nivelPreocupacao) {
        this.nivelPreocupacao = nivelPreocupacao;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("TbGravidadeInsonia{");
        sb.append("idGravidadeInsonia=").append(idGravidadeInsonia);
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", gravidadeInsonia=").append(gravidadeInsonia);
        sb.append(", tipoGravidadeInsonia=").append(tipoGravidadeInsonia);
        sb.append(", satisfacaoPadraoSono=").append(satisfacaoPadraoSono);
        sb.append(", interferenciaAtividadeDiaria=").append(interferenciaAtividadeDiaria);
        sb.append(", percepcaoExterna=").append(percepcaoExterna);
        sb.append(", nivelPreocupacao=").append(nivelPreocupacao);
        sb.append('}');
        return sb.toString();
    }
}
