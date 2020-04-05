package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Medicamento;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta
 * de usuarios para o objeto {@link Medicamento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class MedicamentoObjectToBean implements Converter<Object[], Medicamento> {

    private static final int
        CAMPO_1 = 0,
        CAMPO_2 = 1,

        // Numero de colunas da query executada:
        SQL_CONT_COLUNAS = 2;

    @Override
    public final Medicamento convert(final Object[] source) {

        final Medicamento doc = new Medicamento();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdMedicamento(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsMedicamento((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

}