package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.QuestHabitos;
import br.com.zolp.estudozolp.entity.TbQuestHabitosUltimoMes;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbQuestHabitosUltimoMes} para o objeto {@link QuestHabitos}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class QuestHabitosToBean implements Converter<TbQuestHabitosUltimoMes, QuestHabitos> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final QuestHabitos convert(final Object[] source) {

        final QuestHabitos doc = new QuestHabitos();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdQuestHabitos(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setIdVisita(Numbers.longValue(source[CAMPO_2]));
            }

        }

        return doc;
    }

    @Override
    public final QuestHabitos convert(final TbQuestHabitosUltimoMes source) {

        QuestHabitos doc = new QuestHabitos();

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

}
