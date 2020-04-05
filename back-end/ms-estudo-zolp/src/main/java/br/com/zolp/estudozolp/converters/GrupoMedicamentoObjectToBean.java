package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.GrupoMedicamento;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta
 * para o objeto {@link GrupoMedicamento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class GrupoMedicamentoObjectToBean implements Converter<Object[], GrupoMedicamento> {

    private static final int
        CAMPO_1 = 0,
        CAMPO_2 = 1,

        // Numero de colunas da query executada:
        SQL_CONT_COLUNAS = 2;

    @Override
    public final GrupoMedicamento convert(final Object[] source) {

        final GrupoMedicamento doc = new GrupoMedicamento();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdGrupoMedicamento(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsGrupoMedicamento((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

}