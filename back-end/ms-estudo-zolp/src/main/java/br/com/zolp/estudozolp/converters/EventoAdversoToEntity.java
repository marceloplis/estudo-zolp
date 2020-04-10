package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.EventoAdverso;
import br.com.zolp.estudozolp.entity.TbEventoAdverso;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link EventoAdverso} para o objeto {@link TbEventoAdverso}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class EventoAdversoToEntity implements Converter<EventoAdverso, TbEventoAdverso> {

    @Override
    public final TbEventoAdverso convert(final EventoAdverso source) {

        TbEventoAdverso doc = new TbEventoAdverso();

        if (source != null) {

            doc.setIdEventoAdverso(source.getIdEventoAdverso());
            doc.setIdDoenca(source.getIdDoenca());
            doc.setIdPaciente(source.getIdPaciente());
            doc.setDtInclusao(source.getDtInclusao());
            doc.setDtInicio(source.getDtInicio());
            doc.setDtFim(source.getDtFim());
            doc.setPER_E01(source.getPER_E01());
            doc.setPER_E02(source.getPER_E02());
            doc.setPER_E03(source.getPER_E03());
            doc.setPER_E04(source.getPER_E04());
            doc.setObservacao(source.getObservacao());
            doc.setStAprovacao(source.getStAprovacao());
            doc.setAssinatura(source.getAssinatura());
            doc.setDtAssinatura(source.getDtAssinatura());
            doc.setNuVisita(source.getNuVisita());

        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbEventoAdverso populate(final EventoAdverso source) {

        TbEventoAdverso doc = new TbEventoAdverso();

        if(Eval.isNotEmpty(source.getIdEventoAdverso())) {
            doc.setIdEventoAdverso(source.getIdEventoAdverso());
        }

        if(Eval.isNotEmpty(source.getIdDoenca())) {
            doc.setIdDoenca(source.getIdDoenca());
        }

        if(Eval.isNotEmpty(source.getIdPaciente())) {
            doc.setIdPaciente(source.getIdPaciente());
        }

        if(Eval.isNotEmpty(source.getDtInclusao())) {
            doc.setDtInclusao(source.getDtInclusao());
        }

        if(Eval.isNotEmpty(source.getDtInicio())) {
            doc.setDtInicio(source.getDtInicio());
        }

        if(Eval.isNotEmpty(source.getDtFim())) {
            doc.setDtFim(source.getDtFim());
        }

        if(Eval.isNotEmpty(source.getPER_E01())) {
            doc.setPER_E01(source.getPER_E01());
        }

        if(Eval.isNotEmpty(source.getPER_E02())) {
            doc.setPER_E02(source.getPER_E02());
        }

        if(Eval.isNotEmpty(source.getPER_E03())) {
            doc.setPER_E03(source.getPER_E03());
        }

        if(Eval.isNotEmpty(source.getPER_E04())) {
            doc.setPER_E04(source.getPER_E04());
        }

        if(Eval.isNotEmpty(source.getObservacao())) {
            doc.setObservacao(source.getObservacao());
        }

        if(Eval.isNotEmpty(source.getStAprovacao())) {
            doc.setStAprovacao(source.getStAprovacao());
        }

        if(Eval.isNotEmpty(source.getAssinatura())) {
            doc.setAssinatura(source.getAssinatura());
        }

        if(Eval.isNotEmpty(source.getDtAssinatura())) {
            doc.setDtAssinatura(source.getDtAssinatura());
        }

        if(Eval.isNotNull(source.getNuVisita())) {
            doc.setNuVisita(source.getNuVisita());
        }

        return doc;
    }
}
