package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.EventoAdverso;
import br.com.zolp.estudozolp.entity.TbEventoAdverso;
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

}
