package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelo mapeamento da entidade TbSaidaEstudo.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "TbSaidaEstudo")
public class TbQuestHabitosUltimoMes implements Serializable{

    private static final long serialVersionUID = -2797653853629696970L;

    @Id
	@SequenceGenerator(name = "seq_quest_habitos_generator", sequenceName = "seq_quest_habitos", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_quest_habitos_generator")
    @Column(name = "idQuestHabitos", nullable = false)
    private Long idQuestHabitos;

    @Column(name = "idVisita", nullable = false)
    private Long idVisita;

    @Column(name = "horaDormir")
    private String horaDormir;

    @Column(name = "tempoParaAdormecer")
    private Integer tempoParaAdormecer;

    @Column(name = "horaAcordar")
    private String horaAcordar;

    @Column(name = "horasSono")
    private Integer horasSono;

    /**
     * Problemas no Sono (1 - Não conseguia dormir em 30 minutos / 2 - Despertou no meio da noite ou de madrugada / 3 - Teve que levantar à noite para ir ao banheiro / 4 - Não conseguia respirar de forma satisfatória / 5 - Tossia ou roncava alto / 6 - Sentia muito frio / 7 - Sentia muito calor / 8 - Tinha sonhos ruins / 9 - Tinha dor / 10 - Outra razão (por favor, descreva em outro problema)) 
     */
    @Column(name = "problemasSono")
    private Integer problemasSono;

    /**
     * Tipo de Problemas no Sono (1 - Nunca no ultimo mes / 2 - Menos de uma vez por semana / 3 - Uma ou Dusas Vezes por semana / 4 - Tres ou mais vezes por semana)
     */
    @Column(name = "tipoProblemaSono")
    private Integer tipoProblemaSono;

    @Column(name = "outroProblemaSono")
    private String outroProblemaSono;

    /**
     * Qualidade do Sono (1 - Muito boa / 2 - Boa / 3 - Ruim / 4 - Muito ruim) 
     */
    @Column(name = "qualidadeSono")
    private Integer qualidadeSono;

    /**
     * Frequencia de Medicamento para o Sono ( 1 - Nunca no último mês / 2 - Menos de uma vez por semana / 3 - Uma ou duas vezes por semana / 4 - Três ou mais vezes por semana ) 
     */
    @Column(name = "freqMedicamentoSono")
    private Integer freqMedicamentoSono;

    /**
     * Frequencia Dificuldade se manter acordado ( 1 - Nunca no último mês / 2 - Menos de uma vez por semana / 3 - Uma ou duas vezes por semana / 4 - Três ou mais vezes por semana ) 
     */
    @Column(name = "freqDificManterAcordado")
    private Integer freqDificManterAcordado;

    /**
     * Dificuldade para manter o entusiasmo (1 - Nenhum pouco problemático / 2 - Apenas ligeiramente problemático / 3 - Um pouco problemático / 4 - Muito problemático ) 
     */
    @Column(name = "difManterEstusiasmo")
    private Integer difManterEstusiasmo;

    /**
     * Divide Quarto ou Cama com Parceiro (1 - Não tem parceiro de cama ou colega de quarto / 2 - Parceiro ou colega em outro quarto / 3 - Parceiro no mesmo quarto, mas não na mesma cama / 4 - Parceiro na mesma cama) 
     */
    @Column(name = "divideQuartoCama")
    private Integer divideQuartoCama;

    /**
     * Report de Problemas de Sono por terceiros (1 - Ronco Alto / 2 - Longas Pausas Respiracao / 3 - Chutar ou Sacudir Pernas / 4 - Desorientacao ou confusao / 5 - Outras inquietacoes (descreva em outro problema)) 
     */
    @Column(name = "reporProblemasSono")
    private Integer reporProblemasSono;

    /**
     * Tipo de report de Problemas de Sono por terceiros (1 - Nunca no ultimo mes / 2 - Menos de uma vez por semana / 3 - Uma ou Dusas Vezes por semana / 4 - Tres ou mais vezes por semana) 
     */
    @Column(name = "tipoReportProblemaSono")
    private Integer tipoReportProblemaSono;

    @Column(name = "outroReportProblemaSono")
    private String outroReportProblemaSono;

    public TbQuestHabitosUltimoMes() {
    }

    /**
     * Obtem o valor corrente de idQuestHabitos.
     *
     * @return O valor corrente de idQuestHabitos.
     */
    public Long getIdQuestHabitos() {
        return idQuestHabitos;
    }

    /**
     * Define um novo valor para idQuestHabitos.
     *
     * @param idQuestHabitos O novo valor para idQuestHabitos.
     */
    public void setIdQuestHabitos(final Long idQuestHabitos) {
        this.idQuestHabitos = idQuestHabitos;
    }

    /**
     * Obtem o valor corrente de idVisita.
     *
     * @return O valor corrente de idVisita.
     */
    public Long getIdVisita() {
        return idVisita;
    }

    /**
     * Define um novo valor para idVisita.
     *
     * @param idVisita O novo valor para idVisita.
     */
    public void setIdVisita(final Long idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * Obtem o valor corrente de horaDormir.
     *
     * @return O valor corrente de horaDormir.
     */
    public String getHoraDormir() {
        return horaDormir;
    }

    /**
     * Define um novo valor para horaDormir.
     *
     * @param horaDormir O novo valor para horaDormir.
     */
    public void setHoraDormir(final String horaDormir) {
        this.horaDormir = horaDormir;
    }

    /**
     * Obtem o valor corrente de tempoParaAdormecer.
     *
     * @return O valor corrente de tempoParaAdormecer.
     */
    public Integer getTempoParaAdormecer() {
        return tempoParaAdormecer;
    }

    /**
     * Define um novo valor para tempoParaAdormecer.
     *
     * @param tempoParaAdormecer O novo valor para tempoParaAdormecer.
     */
    public void setTempoParaAdormecer(final Integer tempoParaAdormecer) {
        this.tempoParaAdormecer = tempoParaAdormecer;
    }

    /**
     * Obtem o valor corrente de horaAcordar.
     *
     * @return O valor corrente de horaAcordar.
     */
    public String getHoraAcordar() {
        return horaAcordar;
    }

    /**
     * Define um novo valor para horaAcordar.
     *
     * @param horaAcordar O novo valor para horaAcordar.
     */
    public void setHoraAcordar(final String horaAcordar) {
        this.horaAcordar = horaAcordar;
    }

    /**
     * Obtem o valor corrente de horasSono.
     *
     * @return O valor corrente de horasSono.
     */
    public Integer getHorasSono() {
        return horasSono;
    }

    /**
     * Define um novo valor para horasSono.
     *
     * @param horasSono O novo valor para horasSono.
     */
    public void setHorasSono(final Integer horasSono) {
        this.horasSono = horasSono;
    }

    /**
     * Obtem o valor corrente de problemasSono.
     *
     * @return O valor corrente de problemasSono.
     */
    public Integer getProblemasSono() {
        return problemasSono;
    }

    /**
     * Define um novo valor para problemasSono.
     *
     * @param problemasSono O novo valor para problemasSono.
     */
    public void setProblemasSono(final Integer problemasSono) {
        this.problemasSono = problemasSono;
    }

    /**
     * Obtem o valor corrente de tipoProblemaSono.
     *
     * @return O valor corrente de tipoProblemaSono.
     */
    public Integer getTipoProblemaSono() {
        return tipoProblemaSono;
    }

    /**
     * Define um novo valor para tipoProblemaSono.
     *
     * @param tipoProblemaSono O novo valor para tipoProblemaSono.
     */
    public void setTipoProblemaSono(final Integer tipoProblemaSono) {
        this.tipoProblemaSono = tipoProblemaSono;
    }

    /**
     * Obtem o valor corrente de outroProblemaSono.
     *
     * @return O valor corrente de outroProblemaSono.
     */
    public String getOutroProblemaSono() {
        return outroProblemaSono;
    }

    /**
     * Define um novo valor para outroProblemaSono.
     *
     * @param outroProblemaSono O novo valor para outroProblemaSono.
     */
    public void setOutroProblemaSono(final String outroProblemaSono) {
        this.outroProblemaSono = outroProblemaSono;
    }

    /**
     * Obtem o valor corrente de qualidadeSono.
     *
     * @return O valor corrente de qualidadeSono.
     */
    public Integer getQualidadeSono() {
        return qualidadeSono;
    }

    /**
     * Define um novo valor para qualidadeSono.
     *
     * @param qualidadeSono O novo valor para qualidadeSono.
     */
    public void setQualidadeSono(final Integer qualidadeSono) {
        this.qualidadeSono = qualidadeSono;
    }

    /**
     * Obtem o valor corrente de freqMedicamentoSono.
     *
     * @return O valor corrente de freqMedicamentoSono.
     */
    public Integer getFreqMedicamentoSono() {
        return freqMedicamentoSono;
    }

    /**
     * Define um novo valor para freqMedicamentoSono.
     *
     * @param freqMedicamentoSono O novo valor para freqMedicamentoSono.
     */
    public void setFreqMedicamentoSono(final Integer freqMedicamentoSono) {
        this.freqMedicamentoSono = freqMedicamentoSono;
    }

    /**
     * Obtem o valor corrente de freqDificManterAcordado.
     *
     * @return O valor corrente de freqDificManterAcordado.
     */
    public Integer getFreqDificManterAcordado() {
        return freqDificManterAcordado;
    }

    /**
     * Define um novo valor para freqDificManterAcordado.
     *
     * @param freqDificManterAcordado O novo valor para freqDificManterAcordado.
     */
    public void setFreqDificManterAcordado(final Integer freqDificManterAcordado) {
        this.freqDificManterAcordado = freqDificManterAcordado;
    }

    /**
     * Obtem o valor corrente de difManterEstusiasmo.
     *
     * @return O valor corrente de difManterEstusiasmo.
     */
    public Integer getDifManterEstusiasmo() {
        return difManterEstusiasmo;
    }

    /**
     * Define um novo valor para difManterEstusiasmo.
     *
     * @param difManterEstusiasmo O novo valor para difManterEstusiasmo.
     */
    public void setDifManterEstusiasmo(final Integer difManterEstusiasmo) {
        this.difManterEstusiasmo = difManterEstusiasmo;
    }

    /**
     * Obtem o valor corrente de divideQuartoCama.
     *
     * @return O valor corrente de divideQuartoCama.
     */
    public Integer getDivideQuartoCama() {
        return divideQuartoCama;
    }

    /**
     * Define um novo valor para divideQuartoCama.
     *
     * @param divideQuartoCama O novo valor para divideQuartoCama.
     */
    public void setDivideQuartoCama(final Integer divideQuartoCama) {
        this.divideQuartoCama = divideQuartoCama;
    }

    /**
     * Obtem o valor corrente de reporProblemasSono.
     *
     * @return O valor corrente de reporProblemasSono.
     */
    public Integer getReporProblemasSono() {
        return reporProblemasSono;
    }

    /**
     * Define um novo valor para reporProblemasSono.
     *
     * @param reporProblemasSono O novo valor para reporProblemasSono.
     */
    public void setReporProblemasSono(final Integer reporProblemasSono) {
        this.reporProblemasSono = reporProblemasSono;
    }

    /**
     * Obtem o valor corrente de tipoReportProblemaSono.
     *
     * @return O valor corrente de tipoReportProblemaSono.
     */
    public Integer getTipoReportProblemaSono() {
        return tipoReportProblemaSono;
    }

    /**
     * Define um novo valor para tipoReportProblemaSono.
     *
     * @param tipoReportProblemaSono O novo valor para tipoReportProblemaSono.
     */
    public void setTipoReportProblemaSono(final Integer tipoReportProblemaSono) {
        this.tipoReportProblemaSono = tipoReportProblemaSono;
    }

    /**
     * Obtem o valor corrente de outroReportProblemaSono.
     *
     * @return O valor corrente de outroReportProblemaSono.
     */
    public String getOutroReportProblemaSono() {
        return outroReportProblemaSono;
    }

    /**
     * Define um novo valor para outroReportProblemaSono.
     *
     * @param outroReportProblemaSono O novo valor para outroReportProblemaSono.
     */
    public void setOutroReportProblemaSono(final String outroReportProblemaSono) {
        this.outroReportProblemaSono = outroReportProblemaSono;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("TbQuestHabitosUltimoMes{");
        sb.append("idQuestHabitos=").append(idQuestHabitos);
        sb.append(", idVisita=").append(idVisita);
        sb.append(", horaDormir='").append(horaDormir).append('\'');
        sb.append(", tempoParaAdormecer=").append(tempoParaAdormecer);
        sb.append(", horaAcordar='").append(horaAcordar).append('\'');
        sb.append(", horasSono=").append(horasSono);
        sb.append(", problemasSono=").append(problemasSono);
        sb.append(", tipoProblemaSono=").append(tipoProblemaSono);
        sb.append(", outroProblemaSono='").append(outroProblemaSono).append('\'');
        sb.append(", qualidadeSono=").append(qualidadeSono);
        sb.append(", freqMedicamentoSono=").append(freqMedicamentoSono);
        sb.append(", freqDificManterAcordado=").append(freqDificManterAcordado);
        sb.append(", difManterEstusiasmo=").append(difManterEstusiasmo);
        sb.append(", divideQuartoCama=").append(divideQuartoCama);
        sb.append(", reporProblemasSono=").append(reporProblemasSono);
        sb.append(", tipoReportProblemaSono=").append(tipoReportProblemaSono);
        sb.append(", outroReportProblemaSono='").append(outroReportProblemaSono).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
