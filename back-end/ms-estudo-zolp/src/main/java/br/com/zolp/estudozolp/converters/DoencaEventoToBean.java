package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.DoencaEvento;
import br.com.zolp.estudozolp.entity.TbDoencaEvento;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbDoencaEvento} para o objeto {@link DoencaEvento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class DoencaEventoToBean implements Converter<TbDoencaEvento, DoencaEvento> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final DoencaEvento convert(final Object[] source) {

        final DoencaEvento doc = new DoencaEvento();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdDoencaEvento(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsDoenca((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

    @Override
    public final DoencaEvento convert(final TbDoencaEvento source) {

        DoencaEvento doc = new DoencaEvento();

        if (source != null) {

            doc.setIdDoencaEvento(source.getIdDoencaEvento());
            doc.setDsDoenca(source.getDsDoenca());
            doc.setSiglaDoenca(source.getSiglaDoenca());

        }

        return doc;
    }

}
