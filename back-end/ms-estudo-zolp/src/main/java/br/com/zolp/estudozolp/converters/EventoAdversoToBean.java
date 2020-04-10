package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.EventoAdverso;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.entity.TbEventoAdverso;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbEventoAdverso} para o objeto {@link UsuarioSistema}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class EventoAdversoToBean implements Converter<TbEventoAdverso, EventoAdverso> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final EventoAdverso convert(final Object[] source) {

        final EventoAdverso doc = new EventoAdverso();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdEventoAdverso(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setObservacao((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

    @Override
    public final EventoAdverso convert(final TbEventoAdverso source) {

        EventoAdverso doc = new EventoAdverso();

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
