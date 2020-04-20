package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.QuestHabitos;
import br.com.zolp.estudozolp.entity.TbQuestHabitosUltimoMes;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link QuestHabitos} para o objeto {@link TbQuestHabitosUltimoMes}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class QuestHabitosToEntity implements Converter<QuestHabitos, TbQuestHabitosUltimoMes> {

    @Override
    public final TbQuestHabitosUltimoMes convert(final QuestHabitos source) {

        TbQuestHabitosUltimoMes doc = new TbQuestHabitosUltimoMes();

        if (source != null) {

            doc.setIdQuestHabitos(source.getIdQuestHabitos());
            doc.setIdVisita(source.getIdVisita());
            doc.setHoraDormir(source.getHoraDormir());
            doc.setTempoParaAdormecer(source.getTempoParaAdormecer());
            doc.setHoraAcordar(source.getHoraAcordar());
            doc.setHorasSono(source.getHorasSono());
            doc.setProblemasSono(source.getProblemasSono());
            doc.setTipoProblemaSono(source.getTipoProblemaSono());
            doc.setOutroProblemaSono(source.getOutroProblemaSono());
            doc.setQualidadeSono(source.getQualidadeSono());
            doc.setFreqMedicamentoSono(source.getFreqMedicamentoSono());
            doc.setFreqDificManterAcordado(source.getFreqDificManterAcordado());
            doc.setDifManterEstusiasmo(source.getDifManterEstusiasmo());
            doc.setDivideQuartoCama(source.getDivideQuartoCama());
            doc.setReporProblemasSono(source.getReporProblemasSono());
            doc.setTipoReportProblemaSono(source.getTipoReportProblemaSono());
            doc.setOutroReportProblemaSono(source.getOutroReportProblemaSono());
        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbQuestHabitosUltimoMes populate(final QuestHabitos source) {

        TbQuestHabitosUltimoMes doc = new TbQuestHabitosUltimoMes();

        if(Eval.isNotNull(source.getIdQuestHabitos())) {
            doc.setIdQuestHabitos(source.getIdQuestHabitos());
        }

        if(Eval.isNotNull(source.getIdVisita())) {
            doc.setIdVisita(source.getIdVisita());
        }

        if(Eval.isNotNull(source.getHoraDormir())) {
            doc.setHoraDormir(source.getHoraDormir());
        }

        if(Eval.isNotNull(source.getTempoParaAdormecer())) {
            doc.setTempoParaAdormecer(source.getTempoParaAdormecer());
        }

        if(Eval.isNotNull(source.getHoraAcordar())) {
            doc.setHoraAcordar(source.getHoraAcordar());
        }

        if(Eval.isNotNull(source.getHorasSono())) {
            doc.setHorasSono(source.getHorasSono());
        }

        if(Eval.isNotNull(source.getProblemasSono())) {
            doc.setProblemasSono(source.getProblemasSono());
        }

        if(Eval.isNotNull(source.getTipoProblemaSono())) {
            doc.setTipoProblemaSono(source.getTipoProblemaSono());
        }

        if(Eval.isNotNull(source.getOutroProblemaSono())) {
            doc.setOutroProblemaSono(source.getOutroProblemaSono());
        }

        if(Eval.isNotNull(source.getQualidadeSono())) {
            doc.setQualidadeSono(source.getQualidadeSono());
        }

        if(Eval.isNotNull(source.getFreqMedicamentoSono())) {
            doc.setFreqMedicamentoSono(source.getFreqMedicamentoSono());
        }

        if(Eval.isNotNull(source.getFreqDificManterAcordado())) {
            doc.setFreqDificManterAcordado(source.getFreqDificManterAcordado());
        }

        if(Eval.isNotNull(source.getDifManterEstusiasmo())) {
            doc.setDifManterEstusiasmo(source.getDifManterEstusiasmo());
        }

        if(Eval.isNotNull(source.getDivideQuartoCama())) {
            doc.setDivideQuartoCama(source.getDivideQuartoCama());
        }

        if(Eval.isNotNull(source.getReporProblemasSono())) {
            doc.setReporProblemasSono(source.getReporProblemasSono());
        }

        if(Eval.isNotNull(source.getTipoReportProblemaSono())) {
            doc.setTipoReportProblemaSono(source.getTipoReportProblemaSono());
        }

        if(Eval.isNotNull(source.getOutroReportProblemaSono())) {
            doc.setOutroReportProblemaSono(source.getOutroReportProblemaSono());
        }

        return doc;
    }
}
