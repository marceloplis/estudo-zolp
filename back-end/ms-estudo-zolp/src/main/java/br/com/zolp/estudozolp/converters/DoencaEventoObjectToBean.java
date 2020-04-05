package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.DoencaEvento;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta
 * para o objeto {@link DoencaEvento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class DoencaEventoObjectToBean implements Converter<Object[], DoencaEvento> {

    private static final int
        CAMPO_1 = 0,
        CAMPO_2 = 1,

        // Numero de colunas da query executada:
        SQL_CONT_COLUNAS = 2;

    @Override
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

}