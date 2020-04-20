package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelas informacoes de QuestHabitos.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestHabitos implements Serializable {

    private static final long serialVersionUID = 15245853629696970L;

    private Long idQuestHabitos;
    private Long idVisita;
    private String horaDormir;
    private Integer tempoParaAdormecer;
    private String horaAcordar;
    private Integer horasSono;
    private Integer problemasSono;
    private Integer tipoProblemaSono;
    private String outroProblemaSono;
    private Integer qualidadeSono;
    private Integer freqMedicamentoSono;
    private Integer freqDificManterAcordado;
    private Integer difManterEstusiasmo;
    private Integer divideQuartoCama;
    private Integer reporProblemasSono;
    private Integer tipoReportProblemaSono;
    private String outroReportProblemaSono;

    public QuestHabitos() {
    }

    /**
     * Obtem o valor corrente de idQuestHabitos.
     *
     * @return O valor corrente de idQuestHabitos.
     */
    public final Long getIdQuestHabitos() {
        return idQuestHabitos;
    }

    /**
     * Define um novo valor para idQuestHabitos.
     *
     * @param idQuestHabitos O novo valor para idQuestHabitos.
     */
    public final void setIdQuestHabitos(final Long idQuestHabitos) {
        this.idQuestHabitos = idQuestHabitos;
    }

    /**
     * Obtem o valor corrente de idVisita.
     *
     * @return O valor corrente de idVisita.
     */
    public final Long getIdVisita() {
        return idVisita;
    }

    /**
     * Define um novo valor para idVisita.
     *
     * @param idVisita O novo valor para idVisita.
     */
    public final void setIdVisita(final Long idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * Obtem o valor corrente de horaDormir.
     *
     * @return O valor corrente de horaDormir.
     */
    public final String getHoraDormir() {
        return horaDormir;
    }

    /**
     * Define um novo valor para horaDormir.
     *
     * @param horaDormir O novo valor para horaDormir.
     */
    public final void setHoraDormir(final String horaDormir) {
        this.horaDormir = horaDormir;
    }

    /**
     * Obtem o valor corrente de tempoParaAdormecer.
     *
     * @return O valor corrente de tempoParaAdormecer.
     */
    public final Integer getTempoParaAdormecer() {
        return tempoParaAdormecer;
    }

    /**
     * Define um novo valor para tempoParaAdormecer.
     *
     * @param tempoParaAdormecer O novo valor para tempoParaAdormecer.
     */
    public final void setTempoParaAdormecer(final Integer tempoParaAdormecer) {
        this.tempoParaAdormecer = tempoParaAdormecer;
    }

    /**
     * Obtem o valor corrente de horaAcordar.
     *
     * @return O valor corrente de horaAcordar.
     */
    public final String getHoraAcordar() {
        return horaAcordar;
    }

    /**
     * Define um novo valor para horaAcordar.
     *
     * @param horaAcordar O novo valor para horaAcordar.
     */
    public final void setHoraAcordar(final String horaAcordar) {
        this.horaAcordar = horaAcordar;
    }

    /**
     * Obtem o valor corrente de horasSono.
     *
     * @return O valor corrente de horasSono.
     */
    public final Integer getHorasSono() {
        return horasSono;
    }

    /**
     * Define um novo valor para horasSono.
     *
     * @param horasSono O novo valor para horasSono.
     */
    public final void setHorasSono(final Integer horasSono) {
        this.horasSono = horasSono;
    }

    /**
     * Obtem o valor corrente de problemasSono.
     *
     * @return O valor corrente de problemasSono.
     */
    public final Integer getProblemasSono() {
        return problemasSono;
    }

    /**
     * Define um novo valor para problemasSono.
     *
     * @param problemasSono O novo valor para problemasSono.
     */
    public final void setProblemasSono(final Integer problemasSono) {
        this.problemasSono = problemasSono;
    }

    /**
     * Obtem o valor corrente de tipoProblemaSono.
     *
     * @return O valor corrente de tipoProblemaSono.
     */
    public final Integer getTipoProblemaSono() {
        return tipoProblemaSono;
    }

    /**
     * Define um novo valor para tipoProblemaSono.
     *
     * @param tipoProblemaSono O novo valor para tipoProblemaSono.
     */
    public final void setTipoProblemaSono(final Integer tipoProblemaSono) {
        this.tipoProblemaSono = tipoProblemaSono;
    }

    /**
     * Obtem o valor corrente de outroProblemaSono.
     *
     * @return O valor corrente de outroProblemaSono.
     */
    public final String getOutroProblemaSono() {
        return outroProblemaSono;
    }

    /**
     * Define um novo valor para outroProblemaSono.
     *
     * @param outroProblemaSono O novo valor para outroProblemaSono.
     */
    public final void setOutroProblemaSono(final String outroProblemaSono) {
        this.outroProblemaSono = outroProblemaSono;
    }

    /**
     * Obtem o valor corrente de qualidadeSono.
     *
     * @return O valor corrente de qualidadeSono.
     */
    public final Integer getQualidadeSono() {
        return qualidadeSono;
    }

    /**
     * Define um novo valor para qualidadeSono.
     *
     * @param qualidadeSono O novo valor para qualidadeSono.
     */
    public final void setQualidadeSono(final Integer qualidadeSono) {
        this.qualidadeSono = qualidadeSono;
    }

    /**
     * Obtem o valor corrente de freqMedicamentoSono.
     *
     * @return O valor corrente de freqMedicamentoSono.
     */
    public final Integer getFreqMedicamentoSono() {
        return freqMedicamentoSono;
    }

    /**
     * Define um novo valor para freqMedicamentoSono.
     *
     * @param freqMedicamentoSono O novo valor para freqMedicamentoSono.
     */
    public final void setFreqMedicamentoSono(final Integer freqMedicamentoSono) {
        this.freqMedicamentoSono = freqMedicamentoSono;
    }

    /**
     * Obtem o valor corrente de freqDificManterAcordado.
     *
     * @return O valor corrente de freqDificManterAcordado.
     */
    public final Integer getFreqDificManterAcordado() {
        return freqDificManterAcordado;
    }

    /**
     * Define um novo valor para freqDificManterAcordado.
     *
     * @param freqDificManterAcordado O novo valor para freqDificManterAcordado.
     */
    public final void setFreqDificManterAcordado(final Integer freqDificManterAcordado) {
        this.freqDificManterAcordado = freqDificManterAcordado;
    }

    /**
     * Obtem o valor corrente de difManterEstusiasmo.
     *
     * @return O valor corrente de difManterEstusiasmo.
     */
    public final Integer getDifManterEstusiasmo() {
        return difManterEstusiasmo;
    }

    /**
     * Define um novo valor para difManterEstusiasmo.
     *
     * @param difManterEstusiasmo O novo valor para difManterEstusiasmo.
     */
    public final void setDifManterEstusiasmo(final Integer difManterEstusiasmo) {
        this.difManterEstusiasmo = difManterEstusiasmo;
    }

    /**
     * Obtem o valor corrente de divideQuartoCama.
     *
     * @return O valor corrente de divideQuartoCama.
     */
    public final Integer getDivideQuartoCama() {
        return divideQuartoCama;
    }

    /**
     * Define um novo valor para divideQuartoCama.
     *
     * @param divideQuartoCama O novo valor para divideQuartoCama.
     */
    public final void setDivideQuartoCama(final Integer divideQuartoCama) {
        this.divideQuartoCama = divideQuartoCama;
    }

    /**
     * Obtem o valor corrente de reporProblemasSono.
     *
     * @return O valor corrente de reporProblemasSono.
     */
    public final Integer getReporProblemasSono() {
        return reporProblemasSono;
    }

    /**
     * Define um novo valor para reporProblemasSono.
     *
     * @param reporProblemasSono O novo valor para reporProblemasSono.
     */
    public final void setReporProblemasSono(final Integer reporProblemasSono) {
        this.reporProblemasSono = reporProblemasSono;
    }

    /**
     * Obtem o valor corrente de tipoReportProblemaSono.
     *
     * @return O valor corrente de tipoReportProblemaSono.
     */
    public final Integer getTipoReportProblemaSono() {
        return tipoReportProblemaSono;
    }

    /**
     * Define um novo valor para tipoReportProblemaSono.
     *
     * @param tipoReportProblemaSono O novo valor para tipoReportProblemaSono.
     */
    public final void setTipoReportProblemaSono(final Integer tipoReportProblemaSono) {
        this.tipoReportProblemaSono = tipoReportProblemaSono;
    }

    /**
     * Obtem o valor corrente de outroReportProblemaSono.
     *
     * @return O valor corrente de outroReportProblemaSono.
     */
    public final String getOutroReportProblemaSono() {
        return outroReportProblemaSono;
    }

    /**
     * Define um novo valor para outroReportProblemaSono.
     *
     * @param outroReportProblemaSono O novo valor para outroReportProblemaSono.
     */
    public final void setOutroReportProblemaSono(final String outroReportProblemaSono) {
        this.outroReportProblemaSono = outroReportProblemaSono;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("QuestHabitos{");
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
